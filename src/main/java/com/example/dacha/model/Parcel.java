package com.example.dacha.model;

import com.example.dacha.model.RollesAndUsers.Landowner;
import com.example.dacha.model.RollesAndUsers.RoleOwner;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
//@NoArgsConstructor

@Data
public class Parcel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numcadastr;

    private int area;

    private String view;

    private String note;
/*
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "idOwner")
    //     foreignKey = @ForeignKey(name = "FK_lemma_site"))
    //private RoleOwner roleowner;
    public List<Landowner> Owners;
*/
}
