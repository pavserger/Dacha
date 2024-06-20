package com.example.dacha.model.PaysAndJobs;

import com.example.dacha.model.Parcel;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data

public class ElectrisityTariff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(name = "landowner_id", insertable = false, updatable = false)
    private Long id ;
    @ManyToOne
    @JoinColumn(name = "parcel_id",nullable=false, updatable = false)
    private Parcel parcel;

    private Date datachenge;
    private Double tariff;
    private String note;

}
