package br.com.devDojo.awesome.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class Dateutil {
    public String formatlocalDateTimeToDatabasesStyle(LocalDateTime localDateTime) {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd>hh:mm:ss").format(localDateTime);
    }

}
