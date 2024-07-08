package com.example.ironbank;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "raven")
public class RavenProperties {
    private List<String> destinations;
}
