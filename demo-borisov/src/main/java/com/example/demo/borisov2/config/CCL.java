package com.example.demo.borisov2.config;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class CCL extends ClassLoader {
    @Override
    @SneakyThrows
    public Class<?> findClass(String className)  {
        String fileName = "build/classes/java/main/" + className.replace('.', File.separatorChar) + ".class";
        byte[] bytes = Files.newInputStream(Path.of(fileName)).readAllBytes();
        return defineClass(className, bytes, 0, bytes.length);
    }
}
