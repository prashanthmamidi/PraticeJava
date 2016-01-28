package com.json.examples;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Created by pupsprashu on 16/01/2016.
 */
//binding to generic (typed) containers
public class GenericDataBinding {
    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        //So if you want to bind data into a Map<String,User> you will need to use:
        Map<String, User> obj =
                objectMapper.readValue(
                        new File("src/main/java/com/json/examples/user_data.json"),
                        new TypeReference<Map<String, User>>() { });

        System.out.println("obj.toString() = " + obj.toString());

        //marshall back to Json
        String jsonObj = objectMapper.writeValueAsString(obj);
        System.out.println("jsonObj = " + jsonObj);

    }
}
