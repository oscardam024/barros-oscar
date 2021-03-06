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
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
@Getter
@Setter
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idEvento;

    private String tipoEvento;
    private String nombreEvento;

    @ApiModelProperty(example = "18/02/2022")
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "Europe/Madrid")
    private String fechaEvento;
    private String horaInicio;
    private String horaFin;
    private String comidaCena;
    private String salon;
    private int numeroComensales;
    private String numeroContratoAsociado;
    private int idClienteAsociado;
    private boolean bonoAutobus;

    @JsonIgnore
    @ManyToMany(mappedBy = "eventosAsignados")
    private List<Client> clientesAsociados;
}
