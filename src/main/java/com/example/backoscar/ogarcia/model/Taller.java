package com.example.backoscar.ogarcia.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

@Component
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "taller")
public class Taller {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idTaller;


    private String horaInicio;
    private String horaFin;
    private int numeroAsistentes;
    //@JsonBackReference
    //@JoinTable(
   //         name = "TallerClase",
   //         joinColumns = @JoinColumn(name = "eventoId", referencedColumnName = "idEvento"),
   //         inverseJoinColumns = @JoinColumn(name = "claseId", referencedColumnName = "idClase")
   // )
   // @ManyToMany(cascade = CascadeType.ALL)
   // @JsonIgnore
   // private List<Clase> eventosAsignados;
}
