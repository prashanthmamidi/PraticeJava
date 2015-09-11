package com.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

import static com.collections.COMMAND.*;
import static java.lang.Long.parseLong;

public class test {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, List<DataStore>> multiMap = new ConcurrentHashMap<>();
        List<DataStore> list;

        while (true) {
            String[] input = scanner.nextLine().split(" +");
            if (validCommandType(input[0])) {
                DataStore dataStore = process(input);
                if (null != dataStore) {
                    if (dataStore.getOperationType().equals(QUIT.name())) break;

                    if (dataStore.getOperationType().equals(CREATE.name())) {
                        if (multiMap.containsKey(dataStore.getId())) {
                            System.out.println("ERR A history already exists for identifier " + dataStore.getId());
                        } else {
                            list = new ArrayList<>();
                            list.add(dataStore);
                            multiMap.put(dataStore.getId(), list);
                            System.out.println("OK " + dataStore.getData());
                        }
                }

                    if (dataStore.getOperationType().equals(UPDATE.name())) {
                        if (multiMap.containsKey(dataStore.getId())) {
                            List<DataStore> dataStores = multiMap.get(dataStore.getId());
                            String data = dataStores.get(dataStores.size() - 1).getData();
                            dataStores.add(dataStore);
                            System.out.println("OK " + data);
                        } else {
                            System.out.println("ERR There's no history exists for identifier " + dataStore.getId() + " to update");
                        }
                    }

                    if (dataStore.getOperationType().equals(DELETE.name())) {
                        // chk if timestamp provided
                        if (null != dataStore.getTimeStamp()) {

                    } else {
                            if (multiMap.containsKey(dataStore.getId())) {
                                List<DataStore> dataStores = multiMap.get(dataStore.getId());
                                Long maxTimestamp = dataStores.stream()
                                        .map(DataStore::getTimeStamp)
                                        .max(Long::compare).get();
                                //.max(comparingLong(DataStore::getTimeStamp)).get().getTimeStamp();

                                multiMap.remove(dataStore.getId());
                                System.out.println("OK " + maxTimestamp);
                            } else {
                                System.out.println("Err There's no history exists for identifier " + dataStore.getId() + "to delete");
                            }
                    }


                    }

                multiMap.forEach((k, v) -> System.out.println(k + "=" + v));
                }
            }
            System.out.println("DONE!!!");
        }
    }

    private static DataStore process(String[] input) throws Exception {
        String operationType = input[0];
        if (input[0].equals(QUIT.name())) {
            return getDataStore(operationType);
        }
        if ((input[0].equals(CREATE.name()) || input[0].equals(UPDATE.name()))
                && isValidCreateOrUpdateInput(input)) {
            return new DataStore(getId(input), getTimestamp(input), input[3], operationType);
        }

        if (input[0].equals(DELETE.name()) && isValidDeleteInput(input)) {
            if (input.length == 3)
                return getDataStore(getId(input), getTimestamp(input), operationType);
            else
                return getDataStore(getId(input), operationType);
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
        //<id> [ts]
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

    private static DataStore getDataStore(String operationType) {
        return new DataStore(operationType);
    }

    private static DataStore getDataStore(Integer id, String operationType) {
        return new DataStore(id, operationType);
    }

    private static DataStore getDataStore(Integer id, Long timeStamp, String operationType) {
        return new DataStore(id, timeStamp, operationType);
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
