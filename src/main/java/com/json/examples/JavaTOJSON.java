package com.json.examples;

import java.io.File;
import java.io.IOException;

/**
 * Created by mami01 on 14/05/14.
 * http://www.mkyong.com/java/how-to-convert-java-object-to-from-json-jackson/
 */
public class JavaTOJSON {

    public static void main(String[] args) {
        User user = new User();
/*        ObjectMapper mapper = new ObjectMapper();

        try {

            // convert user object to json string, and save to a file
            mapper.writeValue(new File("c:\\user.json"), user);

            // display to console
            System.out.println(mapper.writeValueAsString(user));

        } catch (JsonGenerationException e) {

            e.printStackTrace();

        } catch (JsonMappingException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }*/
    }
}

/**
 Output

 {"age":29,"messages":["msg 1","msg 2","msg 3"],"name":"mkyong"}
 */