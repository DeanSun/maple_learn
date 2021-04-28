package com.spring.demo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * @author Dean
 */
@Setter
@Getter
@ToString
@ConfigurationProperties(prefix = "my-profile")
@Validated
public class ProfileProperties {

    @NotEmpty
    private String name;

    @Email
    @NotEmpty
    private String email;


    private boolean handsome = Boolean.TRUE;


}
