package utils;

import java.util.ArrayList;
import java.util.HashMap;

public class PetsArray {
    private ArrayList<Object> pets;

    public PetsArray(ArrayList<Object> pets) {
        this.pets = pets;
    }

    public HashMap<String, Integer> getNamesCount() {
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        for (Object pet : pets) {
            String name = ((String[])pet)[1];

            if (result.get(name) == null) {
                result.put(name, 1);
            } else {
                result.put(name, result.get(name) + 1);
            }
        }
        return result;
    }
}
