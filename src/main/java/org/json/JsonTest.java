package org.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTest {

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        Student student = new Student();
        student.setName(null);
        student.setAge("123");
        try {
            String s = objectMapper.writeValueAsString(student);
            System.out.println(s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
