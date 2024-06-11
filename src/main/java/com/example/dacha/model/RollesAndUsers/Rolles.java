package com.example.dacha.model.RollesAndUsers;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//@NoArgsConstructor

@Data
public class Rolles
    {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long idrole;
        private String name;

    }


