package com.mywebexample.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
@RequiredArgsConstructor
public class MyController {

    @Value("classpath:/text.txt")
    private Resource resource;

    @GetMapping("/")
    public ResponseEntity<String> hello() throws IOException {
        String content = resource.getContentAsString(StandardCharsets.UTF_8);
        System.out.println(content);

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(content);
//                .body("<i>Hello</i> <h1>World!</h1>");
    }

    @GetMapping("/test")
    public void test(HttpServletResponse response) throws IOException {
        response.getWriter().write("!!!Hello World!!!");
    }


}
