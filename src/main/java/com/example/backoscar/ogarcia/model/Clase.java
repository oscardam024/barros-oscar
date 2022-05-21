package com.example.backoscar.ogarcia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
@Getter
@Setter
@Table(name = "clase")
public class Clase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idClase;
    private String nombreClase;

    @JsonIgnore
    @JoinTable(
            name = "alumnos_asociados",
            joinColumns = @JoinColumn(name = "alumno_id"),
            inverseJoinColumns = @JoinColumn(name = "clase_id")
    )
    @ManyToMany
    private List<Alumno> clasesAsignadas;

    @JsonIgnore
    @JoinTable(
            name = "profesores_asociados",
            joinColumns = @JoinColumn(name = "profesor_id"),
            inverseJoinColumns = @JoinColumn(name = "clase_id")
    )
    @ManyToMany
    private List<Profesor> pclasesAsignadas;

    @JsonIgnore
    @OneToMany(mappedBy = "claseReseva")
    private List<Reservas> misReservas;


}

