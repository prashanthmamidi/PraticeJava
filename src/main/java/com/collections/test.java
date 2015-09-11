package com.collections;

import javax.xml.crypto.Data;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Long.parseLong;
import static java.util.Comparator.comparingLong;

public class test {

    public static final String QUIT = "QUIT";
    public static final String CREATE = "CREATE";
    public static final String UPDATE = "UPDATE";
    public static final String DELETE = "DELETE";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, List<DataStore>> multiMap = new ConcurrentHashMap<>();
        List<DataStore> list;

        while (true) {
            DataStore dataStore = read(scanner);
            if (dataStore.getOperationType().equals(QUIT)) {
                break;
            }

            if (dataStore.getOperationType().equals(CREATE)) {
                if (multiMap.containsKey(dataStore.getId())) {
                    System.out.println("ERR A history already exists for identifier " + dataStore.getId());
                } else {
                    list = new ArrayList<>();
                    list.add(dataStore);
                    multiMap.put(dataStore.getId(), list);
                    System.out.println("OK " + dataStore.getData());
                }
            }

            if (dataStore.getOperationType().equals(UPDATE)) {
                if (multiMap.containsKey(dataStore.getId())) {
                    List<DataStore> dataStores = multiMap.get(dataStore.getId());
                    String data = dataStores.get(dataStores.size() - 1).getData();
                    dataStores.add(dataStore);
                    System.out.println("OK " + data);
                } else {
                    System.out.println("ERR There's no history exists for identifier " + dataStore.getId() + "to update");
                }
            }

            if (dataStore.getOperationType().equals(DELETE)) {
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

        System.out.println("DONE!!!");
    }

    private static DataStore read(Scanner scanner) {
        String[] split = scanner.nextLine().split(" ");
        String operationType = split[0]; // VALIDATE OPERATION TYPE
        if (split[0].equals(QUIT)) {
            return getDataStore(operationType);
        }

        if (split[0].equals(DELETE)) {
            Long timeStamp = getLong(split, 1);
            if (null != timeStamp)
                return getDataStore(operationType, timeStamp);
            else
                return getDataStore(operationType);
        }
        Integer id = Integer.parseInt(split[1]);
        Long timeStamp = getLong(split, 2);
        String data = split[3];
        return new DataStore(id, timeStamp, data, operationType);
    }

    private static Long getLong(String[] split, int index) {
        if (null != split[index]) return parseLong(split[index]);
        else return null;
    }

    private static DataStore getDataStore(String operationType) {
        return new DataStore(operationType);
    }

    private static DataStore getDataStore(String operationType, Long timeStamp) {
        return new DataStore(operationType, timeStamp);
    }
}
