package com.navid.onlinestoreserver.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String name;
    private String email;
    private Integer age;
    private String gender;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String country;
    @CreationTimestamp(source = SourceType.VM)
    @Column(columnDefinition = "varchar")
    private String createdAt;
    @UpdateTimestamp(source = SourceType.VM)
    private String updatedAt;
}
