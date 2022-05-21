package com.example.backoscar.ogarcia.model;


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
@Table(name = "inventario")
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idItem;

    @ApiModelProperty(value = "Nombre del Item", name = "nombre", dataType = "String", example = "Tornillo")
    private String nombre;

    @ApiModelProperty(value = "Cantidad", name = "cantidad", dataType = "Int", example = "1")
    private int cantidad;

    @JsonIgnore
    @OneToMany(mappedBy = "item")
    private List<Prestamos> itemPrestamos;
}
