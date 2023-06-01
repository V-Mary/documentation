package org.example;

public class DataProcessor {
    private DataOutputStrategy dataOutputStrategy;
    public void setDataOutputStrategy(DataOutputStrategy dataOutputStrategy) {
        this.dataOutputStrategy = dataOutputStrategy;
    }
    public void processData(String data, DataOutputStrategy outputStrategy) {
        outputStrategy.outputData(data);
    }
}
