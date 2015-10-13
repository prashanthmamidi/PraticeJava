package com.collections;

public class Observation {
    private Integer id;
    private Long timeStamp;
    private String data;
    private String commandType;

    public Observation(int id, long timeStamp, String data, String commandType) {
        this.id = id;
        this.timeStamp = timeStamp;
        this.data = data;
        this.commandType = commandType;
    }

    public Observation(String commandType) {
        this.commandType = commandType;
    }

    public Observation(Integer id, Long timeStamp, String commandType) {
        this.id = id;
        this.timeStamp = timeStamp;
        this.commandType = commandType;
    }

    public Observation(Integer id, String commandType) {
        this.id = id;
        this.commandType = commandType;
    }

    public Integer getId() {
        return id;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public String getData() {
        return data;
    }

    public String getCommandType() {
        return commandType;
    }

    @Override
    public String toString() {
        return "Observation{" +
                "id=" + id +
                ", timeStamp=" + timeStamp +
                ", data='" + data + '\'' +
                ", commandType='" + commandType + '\'' +
                '}';
    }
}
