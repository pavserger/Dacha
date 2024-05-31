package main.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "`parcel`")
@Data


public class Parcel
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String numcadastr;

}
