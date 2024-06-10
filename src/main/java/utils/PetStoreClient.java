package utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import constants.PetStatus;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class PetStoreClient {
    private static final String host = "https://petstore.swagger.io/v2/";
    private HttpClient client = HttpClient.newBuilder().build();

    public HttpResponse<String> getUser(String username) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(host + "user/" + username))
                .headers(
                        "accept", "application/json"
                )
                .GET()
                .build();

        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public HttpResponse<String> createUser(
            long id,
            String username,
            String firstName,
            String lastName,
            String email,
            String password,
            String phone,
            long userStatus
    ) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(host + "user"))
                .headers(
                        "Content-Type", "application/json",
                        "accept", "application/json"
                ).POST(HttpRequest.BodyPublishers.ofString(String.format("""
                {
                    "id": %s,
                    "username": "%s",
                    "firstName": "%s",
                    "lastName": "%s",
                    "email": "%s",
                    "password": "%s",
                    "phone": "%s",
                    "userStatus": %s
                }
                """,
                        id, username, firstName, lastName, email,
                        password, phone, userStatus)))
                .build();

        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public HttpResponse<String> getFindByStatus(PetStatus petStatus) {


        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(host + "pet/findByStatus?status=" + petStatus.toString().toLowerCase()))
                .headers(
                        "accept", "application/json"
                )
                .GET()
                .build();

        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Object> findByStatus(PetStatus status) {
        HttpResponse<String> response = getFindByStatus(PetStatus.AVAILABLE);
        JsonArray root = JsonParser.parseString(response.body()).getAsJsonArray();

        ArrayList<Object> pets = new ArrayList<Object>();

        for (JsonElement elem : root.asList()) {
            pets.add(new String[]{
                    elem.getAsJsonObject().get("id").getAsString(),
                    elem.getAsJsonObject().get("name").getAsString()
            });
        }

        return pets;
    }
}
