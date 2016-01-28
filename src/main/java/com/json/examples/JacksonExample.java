package com.json.examples;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

/**
 * Created by pupsprashu on 19/12/2015.
 */
public class JacksonExample {

    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        Staff staff = new Staff("Prashanth", "35", "DEV", new BigDecimal("500"), asList("java", "python"));

        //convert object to Json
        String jsonValue = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff);
        System.out.println("jsonValue = " + jsonValue);
        objectMapper.writeValue(new File("/Users/pupsprashu/Work/PraticeJava/src/main/resources/staff.json"), staff);

        //convert Json to Object
        String staffJson = "{\"name\":\"Prashanth\",\"age\":\"35\",\"position\":\"DEV\",\"salary\":500,\"skills\":[\"java\",\"python\"]}";
        Staff staffObj = objectMapper.readValue(staffJson, Staff.class);
        System.out.println("staffObj.toString() = " + staffObj.toString());

        //Convert a JSON Array format to a Java List object.
        String staffJsonList = "[{\"name\":\"Prashanth\",\"age\":\"35\",\"position\":\"DEV\",\"salary\":500,\"skills\":[\"java\",\"python\"]}" +
                ",{\"name\":\"Vishnu\",\"age\":\"3\",\"position\":\"DEV\",\"salary\":500,\"skills\":[\"java\",\"python\"]}]";
        List<Staff> staffs = objectMapper.readValue(staffJsonList, new TypeReference<List<Staff>>() {});
        System.out.println("JSON Array format to a Java List object....");
        staffs.forEach(staff1 -> System.out.println("staff.toString() = " + staff1.toString()));

        //Convert a JSON to a Map
        String json = "{\"name\":\"Padmaja\", \"age\":34}";
        Map<String, Object> map = objectMapper.readValue(json, new TypeReference<Map<String,Object>>(){});
        System.out.println("map = " + map);

    }
}
