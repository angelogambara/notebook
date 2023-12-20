package com.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Query: ");
        String q = scanner.nextLine();
        String url = "https://api.openweathermap.org/data/2.5/weather?appid=5dd765a29b95b2e058dfd9f33a1dbd0d&q=" + q;

        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode json = mapper.readTree(new URL(url));
            JsonNode weather = json.get("weather");

            if (weather.isArray()) {
                for (JsonNode node : weather) {
                    String main = node.get("main").asText();
                    String description = node.get("description").asText();
                    System.out.println(main + ": " + description);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}