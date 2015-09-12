package com.collections;

import java.util.OptionalLong;

public class TemporalDataStore {
    private Integer id;
    private Long timeStamp;
    private String data;
    private String operationType;

    public TemporalDataStore(int id, long timeStamp, String data, String operationType) {
        this.id = id;
        this.timeStamp = timeStamp;
        this.data = data;
        this.operationType = operationType;
    }

    public TemporalDataStore(String operationType) {
        this.operationType = operationType;
    }

    public TemporalDataStore(Integer id, Long timeStamp, String operationType) {
        this.id = id;
        this.timeStamp = timeStamp;
        this.operationType = operationType;
    }

    public TemporalDataStore(Integer id, String operationType) {
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
