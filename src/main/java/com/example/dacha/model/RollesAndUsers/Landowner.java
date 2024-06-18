package com.example.dacha.model.RollesAndUsers;

import com.example.dacha.model.Parcel;
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
   // @Column(name = "landowner_id", insertable = false, updatable = false)
   // private Long landowner_id ;

    private Long numparcel;
    private String family;
    private String name;
    private String lasName;
    private String phone;
    private String post;
    private String pass;

    @ManyToOne
    @JoinColumn(name = "parcel_id",nullable=false, updatable = false)
    private Parcel parcel;


    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "idroleowner")
        //     foreignKey = @ForeignKey(name = "FK_lemma_site"))
    //private RoleOwner roleowner;
    private List<RoleOwner> roleOwnerList;


}
