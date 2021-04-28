package com.spring.demo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Dean
 */

@Component
@ConfigurationProperties(prefix = "library")
@Setter
@Getter
@ToString
public class LibraryProperties {
    private String location;
    private List<Book> books;

    @Setter
    @Getter
    @ToString
    static class Book{
        String name;
        String description;
    }

}
