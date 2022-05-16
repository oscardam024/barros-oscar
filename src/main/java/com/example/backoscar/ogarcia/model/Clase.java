package com.example.backoscar.ogarcia.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @OneToMany(mappedBy = "alumnos")
    private List<Alumno>alumnos = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "profesoresAsignados")
    private List<Profesor> profesoresAsociados;

}
