package com.example.dacha.model.RollesAndUsers;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data

public class RoleOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idroleowner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idrole")
  //          foreignKey = @ForeignKey(name = "FK_lemma_site"))
    private Rolles role;


}
