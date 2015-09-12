package com.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

import static com.collections.COMMAND.*;
import static java.lang.Long.parseLong;
import static java.util.stream.Collectors.toList;

public class test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, List<TemporalDataStore>> multiMap = new ConcurrentHashMap<>();

        while (true) {
            String[] input = scanner.nextLine().split(" +");
            if (validCommandType(input[0])) {
                TemporalDataStore temporalDataStore = process(input);
                if (null != temporalDataStore) {
                    if (isCommandEquals(temporalDataStore, QUIT)) {
                        break;
                    }
                    if (isCommandEquals(temporalDataStore, CREATE)) {
                        processCreate(multiMap, temporalDataStore);
                    }
                    if (isCommandEquals(temporalDataStore, UPDATE)) {
                        processUpdate(multiMap, temporalDataStore);
                    }
                    if (isCommandEquals(temporalDataStore, DELETE)) {
                        processDelete(multiMap, temporalDataStore);
                    }

                multiMap.forEach((k, v) -> System.out.println(k + "=" + v));
                }
            }
            System.out.println("DONE!!!");
        }
    }

    private static boolean isCommandEquals(TemporalDataStore temporalDataStore, COMMAND command) {
        return temporalDataStore.getOperationType().equals(command.name());
    }

    private static void processDelete(Map<Integer, List<TemporalDataStore>> multiMap, TemporalDataStore temporalDataStore) {
        if (multiMap.containsKey(temporalDataStore.getId())) {
            delete(multiMap, temporalDataStore);
        } else {
            System.out.println("Err There's no history exists for identifier " + temporalDataStore.getId() + " to delete");
        }
    }

    private static void delete(Map<Integer, List<TemporalDataStore>> multiMap, TemporalDataStore temporalDataStore) {
        if (null != temporalDataStore.getTimeStamp()) { // DELETE <id> <timestamp>
            deleteByIdAndTimestamp(multiMap, temporalDataStore);
        } else { // DELETE <id>
            deleteById(multiMap, temporalDataStore);
        }
    }

    private static void deleteById(Map<Integer, List<TemporalDataStore>> multiMap, TemporalDataStore temporalDataStore) {
        Long maxTimestamp = multiMap.get(temporalDataStore.getId()).stream()
                .map(TemporalDataStore::getTimeStamp)
                .max(Long::compare).get();
        multiMap.remove(temporalDataStore.getId());
        System.out.println("OK " + maxTimestamp);
    }

    private static void deleteByIdAndTimestamp(Map<Integer, List<TemporalDataStore>> multiMap, TemporalDataStore temporalDataStore) {
        List<TemporalDataStore> filteredList = multiMap.get(temporalDataStore.getId()).stream()
                .filter(ds -> temporalDataStore.getTimeStamp() > ds.getTimeStamp())
                .collect(toList());
        multiMap.put(temporalDataStore.getId(), filteredList);

        List<TemporalDataStore> updatedTemporalDataStoreList = multiMap.get(temporalDataStore.getId());
        if (!updatedTemporalDataStoreList.isEmpty()) {
            System.out.println("OK " + updatedTemporalDataStoreList.get(updatedTemporalDataStoreList.size() - 1).getData());
        } else {
            System.out.println("Err There's no available observation");
            multiMap.remove(temporalDataStore.getId());
        }
    }

    private static void processUpdate(Map<Integer, List<TemporalDataStore>> multiMap, TemporalDataStore temporalDataStore) {
        if (multiMap.containsKey(temporalDataStore.getId())) {
            List<TemporalDataStore> temporalDataStores = multiMap.get(temporalDataStore.getId());
            String data = temporalDataStores.get(temporalDataStores.size() - 1).getData();
            temporalDataStores.add(temporalDataStore);
            System.out.println("OK " + data);
        } else {
            System.out.println("ERR There's no history exists for identifier " + temporalDataStore.getId() + " to update");
        }
    }

    private static void processCreate(Map<Integer, List<TemporalDataStore>> multiMap, TemporalDataStore temporalDataStore) {
        if (multiMap.containsKey(temporalDataStore.getId())) {
            System.out.println("ERR A history already exists for identifier " + temporalDataStore.getId());
        } else {
            List<TemporalDataStore> list = new ArrayList<>();
            list.add(temporalDataStore);
            multiMap.put(temporalDataStore.getId(), list);
            System.out.println("OK " + temporalDataStore.getData());
        }
    }

    private static TemporalDataStore process(String[] input) {
        String operationType = input[0];
        if (input[0].equals(QUIT.name())) {
            return getDataStore(operationType);
        }
        if ((input[0].equals(CREATE.name()) || input[0].equals(UPDATE.name()))
                && isValidCreateOrUpdateInput(input)) {
            return getDataStore(Integer.parseInt(input[1]), parseLong(input[2]), input[3], operationType);
        }


        if (input[0].equals(DELETE.name()) && isValidDeleteInput(input)) {
            if (input.length == 3)
                return getDataStore(Integer.parseInt(input[1]), parseLong(input[2]), operationType);
            else
                return getDataStore(Integer.parseInt(input[1]), operationType);
        }
        return null;
    }

    private static Boolean isValidCreateOrUpdateInput(String[] input) {
        try {
            getId(input);
            getTimestamp(input);
            String data = input[3];
        } catch (Exception ex) {
            System.out.println("Err Please provide a valid input");
            return false;
        }
        return true;
    }

    private static Boolean isValidDeleteInput(String[] input) {
        try {
            getId(input);
            if (input.length == 3) getTimestamp(input);
        } catch (Exception ex) {
            System.out.println("Err Please provide a valid input");
            return false;
        }
        return true;
    }

    private static Long getTimestamp(String[] input) throws Exception {
        if (input.length >= 3)
            return parseLong(input[2]);
        throw new Exception("Invalid input");
    }

    private static Integer getId(String[] input) throws Exception {
        if (input.length >= 2)
            return Integer.parseInt(input[1]);
        throw new Exception("Invalid input");
    }

    private static TemporalDataStore getDataStore(String operationType) {
        return new TemporalDataStore(operationType);
    }

    private static TemporalDataStore getDataStore(Integer id, String operationType) {
        return new TemporalDataStore(id, operationType);
    }

    private static TemporalDataStore getDataStore(Integer id, Long timestamp, String operationType) {
        return new TemporalDataStore(id, timestamp, operationType);
    }

    private static TemporalDataStore getDataStore(Integer id, Long timestamp, String data, String operationType) {
        return new TemporalDataStore(id, timestamp, data, operationType);
    }
    private static Boolean validCommandType(String commandType) {
        try {
            COMMAND.valueOf(commandType);
        } catch (IllegalArgumentException ex) {
            System.out.println("Err Please provide a valid operation");
            return false;
        }
        return true;
    }
}

enum COMMAND {CREATE, UPDATE, DELETE, GET, LATEST, QUIT}
