package org.example;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class NYCOpenDataApiClient {

    public static void main(String[] args) {
        String apiUrl = "https://data.cityofnewyork.us/City-Government/Parking-Violations-Issued-Fiscal-Year-2023/pvqr-7yc4"; // Замініть на ваш API URL

        // Викликайте метод для отримання даних та їх запису у файл
        try {
            String data = fetchDataFromAPI(apiUrl);
            writeDataToFile(data, "output.txt");
            System.out.println("Дані було успішно записано у файл.");
        } catch (IOException e) {
            System.out.println("Помилка під час отримання або запису даних: " + e.getMessage());
        }
    }

    private static String fetchDataFromAPI(String apiUrl) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(apiUrl);
        CloseableHttpResponse response = null;
        String responseBody = null;

        try {
            response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            responseBody = EntityUtils.toString(entity);
        } finally {
            if (response != null) {
                response.close();
            }
            httpClient.close();
        }

        return responseBody;
    }


    private static void writeDataToFile(String data, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(data);
        }
    }
}
