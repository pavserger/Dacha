package com.example.dacha.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//@NoArgsConstructor

@Data
public class Landowner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String family;
    private String name;
    private String lasName;
    private String phone;
    private String post;

}
