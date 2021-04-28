package com.spring.demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author Dean
 */
@SpringBootApplication
@EnableConfigurationProperties(ProfileProperties.class)
public class DemoApplication implements InitializingBean {

//    private final LibraryProperties library;
//
//    public DemoApplication(LibraryProperties library) {
//        this.library = library;
//    }
//
//    public static void main(String[] args) {
//        SpringApplication.run(DemoApplication.class, args);
//    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println(library.getLocation());
//        System.out.println(library.getBooks());
//    }

    private ProfileProperties profileProperties;

    public DemoApplication(ProfileProperties profileProperties) {
        this.profileProperties = profileProperties;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(profileProperties.toString());
    }
}
