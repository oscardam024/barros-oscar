package com.example.backoscar.ogarcia.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
@Getter
@Setter
@Table(name = "reservas")

public class Reservas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idReservas;

    @ManyToOne
    @JoinColumn(name = "id_clase")
    private Clase claseReseva;

    private Date fecha;

}
