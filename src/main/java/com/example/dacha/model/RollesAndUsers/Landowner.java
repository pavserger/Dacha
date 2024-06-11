package com.example.dacha.model.RollesAndUsers;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "idroleowner")
        //     foreignKey = @ForeignKey(name = "FK_lemma_site"))
    //private RoleOwner roleowner;
    public List<RoleOwner> roleOwnerList;


}
