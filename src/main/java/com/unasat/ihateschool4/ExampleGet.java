package com.unasat.ihateschool4;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class ExampleGet {
    public static void main(String[] args) {
        // Define the endpoint URL
        String endpoint = "https://trajectplannerapi.dulamari.com/students/SE-1123-42";

        // Create an HttpClient instance
        HttpClient client = HttpClient.newHttpClient();

        // Create an HTTP GET request for the specified endpoint
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .build();

        try {
            // Send the GET request and get the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Check if the response code is 200 (OK)
            if (response.statusCode() == 200) {
                // Get the response body (JSON data)
                String jsonResponse = response.body();

                // Create ObjectMapper instance to convert JSON into Java objects
                ObjectMapper objectMapper = new ObjectMapper();

                // Convert JSON into a List of Maps (associated array)
                List<Map<String, Object>> students = objectMapper.readValue(jsonResponse, List.class);

                // Print each student data
                for (Map<String, Object> student : students) {
                    System.out.println("Student ID: " + student.get("id"));
                    System.out.println("First Name: " + student.get("first_name"));
                    System.out.println("Last Name: " + student.get("last_name"));
                    System.out.println("Student Number: " + student.get("student_number"));
                    System.out.println("Password: " + student.get("password"));
                    System.out.println("Total EC: " + student.get("total_ec"));
                    System.out.println("Gender: " + student.get("gender"));
                    System.out.println("Birthdate: " + student.get("birthdate"));
                    System.out.println("-----------------------------");
                }
            } else {
                System.out.println("Error: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


