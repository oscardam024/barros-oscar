package com.example.backoscar.ogarcia.propiedades;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "file")
public class FileStoragesProperties {
    private String uploadDir;
}
