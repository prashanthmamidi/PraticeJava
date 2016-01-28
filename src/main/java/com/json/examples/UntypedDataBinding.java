package com.json.examples;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Created by pupsprashu on 16/01/2016.
 */
//In cases where you do not have (and don't want to create) specific Java classes to bind JSON to/from, "Untyped data binding" may be a better approach
public class UntypedDataBinding {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        //unmarshalling (reading JSON)
        Map<String, Object> userData = objectMapper.readValue(new File("src/main/java/com/json/examples/user.json"), Map.class);
        System.out.println("userData = " + userData.toString());

        //Marshalling back to JSON
        String userDataJson = objectMapper.writeValueAsString(userData);
        System.out.println("userDataJson = " + userDataJson);

    }
}
