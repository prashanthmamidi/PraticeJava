package com.collections;

import java.util.OptionalLong;

public class DataStore {
    private Integer id;
    private Long timeStamp;
    private String data;
    private String operationType;

    public DataStore(int id, long timeStamp, String data, String operationType) {
        this.id = id;
        this.timeStamp = timeStamp;
        this.data = data;
        this.operationType = operationType;
    }

    public DataStore(String operationType) {
        this.operationType = operationType;
    }

    public DataStore() {

    }

    public DataStore(Integer id, Long timeStamp, String operationType) {
        this.id = id;
        this.timeStamp = timeStamp;
        this.operationType = operationType;
    }

    public DataStore(Integer id, String operationType) {
        this.id = id;
        this.operationType = operationType;
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

    public String getOperationType() {
        return operationType;
    }

    @Override
    public String toString() {
        return "DataStore{" +
            "id=" + id +
            ", timeStamp=" + timeStamp +
            ", data='" + data + '\'' +
            ", operationType='" + operationType + '\'' +
            '}';
    }
}
