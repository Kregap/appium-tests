package apiTests;

import constants.PetStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.PetStoreClient;
import utils.PetsArray;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;


public class ApiTest {
    PetStoreClient api;

    @BeforeEach
    public void setUp() {
        api = new PetStoreClient();
    }

    @Test
    public void createUser() {
        String username = "MyAwesomeUser3000";
        api.createUser(
                0,
                username,
                "Johny",
                "White",
                "my@mail.com",
                "myPwd$1",
                "938290382",
                0
        );

        HttpResponse<String> getUserResponse = api.getUser(username);
        String userData = getUserResponse.body();
    }

    @Test
    public void findByStatus() {
        ArrayList<Object> soldPets = api.findByStatus(PetStatus.SOLD);
    }

    @Test
    public void nameSharing() {
        ArrayList<Object> soldPets = api.findByStatus(PetStatus.SOLD);
        PetsArray pets = new PetsArray(soldPets);
        HashMap<String, Integer> petNamesCount = pets.getNamesCount();
    }
}
