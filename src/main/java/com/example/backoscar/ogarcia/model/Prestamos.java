package com.example.backoscar.ogarcia.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Component
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "prestamos")
public class Prestamos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPrestamo;

    @ManyToOne
    @JoinColumn(name = "id_inventario", nullable = false)
    private Inventario item;


    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name = "id_alumno",columnDefinition="integer")
    private Alumno alumno;


    @ApiModelProperty(value = "false", dataType = "Boolean", example = "false")
    private boolean devuelto;
    private int cantidad;

    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDateTime;




}
