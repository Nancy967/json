package com.example.json.resttemplate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestTemplateController {

    @GetMapping("/getForObject")
    public String getForObject(){
        RestTemplate restTemplate = new RestTemplate();

        Student student = restTemplate.getForObject(
                "https://mocki.io/v1/4d2d3523-f584-4999-896d-a3eea78f881d",
                Student.class);

        System.out.println("student id:" + student.getId());
        System.out.println("student name:" + student.getName());
        System.out.println("student contact_phone:" + student.getContactPhone());

        return "getForObject success";
    }
}
