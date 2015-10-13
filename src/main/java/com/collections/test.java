package com.collections;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static com.collections.COMMAND.*;
import static java.lang.Long.parseLong;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class test {

    public static final String REGEX = " +";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, List<Observation>> inMemoryDataStore = new ConcurrentHashMap<>();
        boolean flag = true;

        while (flag) {
            String[] input = scanner.nextLine().split(REGEX);
                Optional<Observation> maybeObservation = getObservationFor(input);
                if (maybeObservation.isPresent()) {
                    Observation observation = maybeObservation.get();
                    switch (valueOf(observation.getCommandType())) {
                        case QUIT:
                            flag = false;
                            break;
                        case CREATE:
                            processCreate(inMemoryDataStore, observation);
                            break;
                        case UPDATE:
                            processUpdate(inMemoryDataStore, observation);
                            break;
                        case DELETE:
                            processDelete(inMemoryDataStore, observation);
                    }
                    // print data
                    inMemoryDataStore.forEach((k, v) -> System.out.println(k + "=" + v));
                }

            System.out.println("DONE!!!");
        }
    }

    private static void processDelete(Map<Integer, List<Observation>> inMemoryDataStore, Observation observation) {
        if (inMemoryDataStore.containsKey(observation.getId())) {
            delete(inMemoryDataStore, observation);
        } else {
            System.out.println("Err There's no history exists for identifier " + observation.getId() + " to delete");
        }
    }

    private static void delete(Map<Integer, List<Observation>> inMemoryDataStore, Observation observation) {
        if (null != observation.getTimeStamp()) {
            deleteByIdAndTimestamp(inMemoryDataStore, observation);
        } else {
            deleteById(inMemoryDataStore, observation);
        }
    }

    private static void deleteById(Map<Integer, List<Observation>> inMemoryDataStore, Observation observation) {
        Long maxTimestamp = inMemoryDataStore.get(observation.getId()).stream()
                .map(Observation::getTimeStamp)
                .max(Long::compare).get();
        inMemoryDataStore.remove(observation.getId());
        System.out.println("OK " + maxTimestamp);
    }

    private static void deleteByIdAndTimestamp(Map<Integer, List<Observation>> inMemoryDataStore, Observation observation) {
        List<Observation> filteredList = inMemoryDataStore.get(observation.getId()).stream()
                .filter(ds -> observation.getTimeStamp() > ds.getTimeStamp())
                .collect(toList());
        inMemoryDataStore.put(observation.getId(), filteredList);

        List<Observation> updatedObservationList = inMemoryDataStore.get(observation.getId());
        if (!updatedObservationList.isEmpty()) {
            System.out.println("OK " + updatedObservationList.get(updatedObservationList.size() - 1).getData());
        } else {
            System.out.println("Err There's no available observation");
            inMemoryDataStore.remove(observation.getId());
        }
    }

    private static void processUpdate(Map<Integer, List<Observation>> inMemoryDataStore, Observation observation) {
        if (inMemoryDataStore.containsKey(observation.getId())) {
            List<Observation> observations = inMemoryDataStore.get(observation.getId());
            String data = observations.get(observations.size() - 1).getData();
            observations.add(observation);
            System.out.println("OK " + data);
        } else {
            System.out.println("ERR There's no history exists for identifier " + observation.getId() + " to update");
        }
    }

    private static void processCreate(Map<Integer, List<Observation>> inMemoryDataStore, Observation observation) {
        if (inMemoryDataStore.containsKey(observation.getId())) {
            System.out.println("ERR A history already exists for identifier " + observation.getId());
        } else {
            List<Observation> list = new ArrayList<>();
            list.add(observation);
            inMemoryDataStore.put(observation.getId(), list);
            System.out.println("OK " + observation.getData());
        }
    }

    private static Optional<Observation> getObservationFor(String[] input) {
        String commandType = input[0];
        if (validCommandType(commandType)) {
            if (commandType.equals(QUIT.name())) {
                return of(getDataStore(commandType));
            }
            if ((commandType.equals(CREATE.name()) || commandType.equals(UPDATE.name()))
                    && isValidCreateOrUpdateInput(input)) {
                return of(getDataStore(Integer.parseInt(input[1]), parseLong(input[2]), input[3], commandType));
            }


            if (commandType.equals(DELETE.name()) && isValidDeleteInput(input)) {
                if (input.length == 3)
                    return of(getDataStore(Integer.parseInt(input[1]), parseLong(input[2]), commandType));
                else
                    return of(getDataStore(Integer.parseInt(input[1]), commandType));
            }
        }
        return empty();
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

    private static Observation getDataStore(String operationType) {
        return new Observation(operationType);
    }

    private static Observation getDataStore(Integer id, String commandType) {
        return new Observation(id, commandType);
    }

    private static Observation getDataStore(Integer id, Long timestamp, String operationType) {
        return new Observation(id, timestamp, operationType);
    }

    private static Observation getDataStore(Integer id, Long timestamp, String data, String operationType) {
        return new Observation(id, timestamp, data, operationType);
    }
    private static Boolean validCommandType(String commandType) {
        try {
            valueOf(commandType);
        } catch (IllegalArgumentException ex) {
            System.out.println("Err Please provide a valid operation");
            return false;
        }
        return true;
    }
}

enum COMMAND {CREATE, UPDATE, DELETE, GET, LATEST, QUIT}
