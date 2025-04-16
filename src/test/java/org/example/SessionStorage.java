package org.example;

import java.util.HashMap;
import java.util.Map;

public class SessionStorage {
    private static final Map<String, String> storage = new HashMap<>();

    public static void store(String key, String value){
        storage.put(key, value);
    }
}
