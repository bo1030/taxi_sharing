package com.taxi_sharing.server.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class test {

    @GetMapping("/hello")
    public String hello()
    {
        return "hello";
    }

    @PostMapping("/hello")
    public String hellopost(@RequestBody Map<String, Object>param)
    {
        return param.get("text").toString();
    }
}
