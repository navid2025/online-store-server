package com.navid.onlinestoreserver.web.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    private Long id;
    @NotBlank
    private String name;
    @NotNull
    @Email
    private String email;
    private Integer age;
    private String gender;
    private String address;
    private String city;
    private String state;
    @Positive
    private String zip;
    private String phone;
    private String country;
    private String registerDate;

}
