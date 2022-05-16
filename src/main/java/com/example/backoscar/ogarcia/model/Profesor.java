package com.example.backoscar.ogarcia.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Component
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "profesore")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idProfesor;

    @ApiModelProperty(value = "Nombre del profesor", name = "nombre", dataType = "String", example = "Pepe")
    private String nombre;

    @ApiModelProperty(value = "Apellido del profesor", dataType = "String", position = 2, example = "Martínez")
    private String apellido;

    @ApiModelProperty(value = "DNI del profesor", dataType = "String", position = 3, example = "12345678M")
    private String dni;

    @ApiModelProperty(value = "Número de teléfono del profesor", dataType = "String", position = 4, example = "666777888")
    private String numeroTelefono;

    @ApiModelProperty(value = "Correo del profesor", dataType = "String", position = 5, example = "pepe.martinez@gmail.com")
    private String correo;

    @ApiModelProperty(value = "Direccion del profesore", dataType = "String", position = 6, example = "Pepe")
    private String direccion;

    @JsonBackReference
    @JoinTable(
            name = "profesorClase",
            joinColumns = @JoinColumn(name = "profesorId", referencedColumnName = "idProfesor"),
            inverseJoinColumns = @JoinColumn(name = "claseId", referencedColumnName = "idClase")
    )
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Event> clasesAsignados;

}
