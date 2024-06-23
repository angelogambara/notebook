package com.example.jsonparser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String appid = "?appid=5dd765a29b95b2e058dfd9f33a1dbd0d";
        String api = "https://api.openweathermap.org/data/2.5/weather" + appid;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Name of the city: ");

        parse(get(api + "&q=" + scanner.nextLine()));
    }

    public static void parse(JsonNode json) {
        System.out.println("Sunrise: " + json.get("sys").get("sunrise").asText());
        System.out.println("Sunset: " + json.get("sys").get("sunset").asText());
    }

    public static JsonNode get(String url) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readTree(new URL(url));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

