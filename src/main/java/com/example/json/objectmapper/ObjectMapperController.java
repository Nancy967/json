package com.example.json.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObjectMapperController {

    @GetMapping("/convert")
    public String convert() throws JsonProcessingException {
        User user = new User();
        user.setId(1);
        user.setName("Nancy");
        user.setContactEmail("test.com");

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResult = objectMapper.writeValueAsString(user);
        System.out.println("json:" + jsonResult);

        String json = "{" +
                "\"id\":3," +
                "\"name\":\"Bob\"," +
                "\"age\":20," +
                "\"contact_email\":\"hello@test.com\"}";
        User userResult = objectMapper.readValue(json, User.class);
        System.out.println("user's id:" + userResult.getId());
        System.out.println("user's name:" + userResult.getName());
        System.out.println("user's contact_email:" + userResult.getContactEmail());

        return "convert success";
    }
}
