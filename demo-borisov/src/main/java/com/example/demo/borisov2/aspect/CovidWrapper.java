package com.example.demo.borisov2.aspect;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CovidWrapper {
    private Object result;
    private String message;
}
