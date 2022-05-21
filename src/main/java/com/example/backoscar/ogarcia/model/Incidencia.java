package com.example.backoscar.ogarcia.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
@Getter
@Setter
@Table(name = "incidencia")
public class Incidencia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idIncidencia;
    @ApiModelProperty(value = "Fatos de la incidencia", name = "datosIncidencia", dataType = "String", example = "Paso esto")
    private String datosIncidencia;
    @ApiModelProperty(value = "Esta resuelta", name = "resuelta", dataType = "Boolean", example = "0")
    private boolean resuelta;
}
