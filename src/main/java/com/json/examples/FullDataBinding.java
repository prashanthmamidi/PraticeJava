package com.json.examples;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Created by pupsprashu on 16/01/2016.
 */
public class FullDataBinding {

    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        //unmarshalling (reading JSON)
        User user = objectMapper.readValue(new File("src/main/java/com/json/examples/user.json"), User.class);

        System.out.println("user.toString() = " + user.toString());

        //Marshalling back to JSON
        String json = objectMapper.writeValueAsString(user);
        objectMapper.writeValue(new File("src/main/java/com/json/examples/user-modified.json"), user);
        System.out.println("json = " + json);
    }
}
