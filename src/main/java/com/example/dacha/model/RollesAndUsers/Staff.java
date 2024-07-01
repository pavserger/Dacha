package com.example.dacha.model.RollesAndUsers;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//@NoArgsConstructor

@Data
public class Staff
    {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long idrole;
        private String family;
        private String name;
        private String lasName;
        private String phone;
        private String post;
        private String pass;
        private String staffName;
        private String brief;

    }


