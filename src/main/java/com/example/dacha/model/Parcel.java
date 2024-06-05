package com.example.dacha.model;

import lombok.Data;

import javax.persistence.*;

@Entity
//@NoArgsConstructor

@Data
public class Parcel
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String numcadastr;

    private int area;

    private String view;

    private String note;

}
