package com.sda.diary.backend;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class TimeClient {
  private final ObjectMapper objectMapper;

  public TimeClient(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  public Instant getCurrentTime() {

    System.out.println("Retrieving current and accurate time from World Clock API \n");

    HttpRequest httpRequest = HttpRequest.newBuilder()
        .GET()
        .uri(URI.create("http://worldclockapi.com/api/json/utc/now"))
        .build();

    HttpClient httpClient = HttpClient.newHttpClient();
    try {
      HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
      int statusCode = httpResponse.statusCode();

      if (statusCode != 200) {
        System.out.println("Unexpected response code: " + statusCode + ". Response body: " + httpResponse.body());
        System.out.println("Failure: Datetime from World Clock API not retrieved thus time from local server has been retrieved!\n");
        return Instant.now();
      }

      String responseBody = httpResponse.body();
      TimeDTO timeDTO = objectMapper.readValue(responseBody, TimeDTO.class);

      String currentDateTime = timeDTO.getCurrentDateTime();
      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm'Z'");
      LocalDateTime localDateTime = LocalDateTime.parse(currentDateTime, dateTimeFormatter);

      System.out.println("Success: Datetime from World Clock API has been retrieved");
      return localDateTime.toInstant(ZoneOffset.UTC);


    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Unable to retrieve current time information");
      return null;
    }


  }
}
