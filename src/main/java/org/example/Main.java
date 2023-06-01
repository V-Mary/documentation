package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;


public class Main {
    public static void main(String[] args) {
        String filename = "output.txt";

        try {
            String data = readDataFromFile(filename);

            DataProcessor dataProcessor = new DataProcessor();
            DataOutputStrategy outputStrategy = getConfiguredOutputStrategy();

            dataProcessor.processData(data, outputStrategy);
        } catch (IOException e) {
            System.out.println("Помилка під час роботи з файлом: " + e.getMessage());
        }
    }

    private static String readDataFromFile(String filename) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filename)));
    }

    private static DataOutputStrategy getConfiguredOutputStrategy() {
        // Зчитайте значення з конфігураційного файлу або іншого джерела налаштувань
        String outputType = readOutputTypeFromConfig();

        if (outputType.equals("console")) {
            return new ConsoleOutputStrategy();
        } else if (outputType.equals("redis")) {
            String redisHost = "localhost";
            int redisPort = 6379;
            return new RedisOutputStrategy(redisHost, redisPort);
        }

        return new ConsoleOutputStrategy();
    }

    private static String readOutputTypeFromConfig() {
        Properties properties = new Properties();

        try {
            properties.load(Main.class.getClassLoader().getResourceAsStream("application.properties"));
            return properties.getProperty("outputType");
        } catch (IOException e) {
            System.out.println("Помилка під час зчитування конфігураційного файлу: " + e.getMessage());
        }

        return "";
    }
}