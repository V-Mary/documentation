package org.example;

public class ConsoleOutputStrategy implements DataOutputStrategy {
    @Override
    public void outputData(String data) {
        System.out.println("Дані: " + data);
    }
}
