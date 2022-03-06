package com.example.backoscar.ogarcia.model;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "DICCIONARIO")
public class Diccionario {
    private Integer id;
    private Integer id_tipo;
    private String valor;

    @JsonIgnore
    private TipoValor tipoValorD_by_tipoValor_id;

    @JsonIgnore
    private List<Event> eventos_by_eventos_code;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Id_Tipo")
    public Integer getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(Integer id_tipo) {
        this.id_tipo = id_tipo;
    }

    @Basic
    @Column(name = "Valor")
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Diccionario)) return false;

        Diccionario that = (Diccionario) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (id_tipo != null ? !id_tipo.equals(that.id_tipo) : that.id_tipo != null) return false;
        if (valor != null ? !valor.equals(that.valor) : that.valor != null) return false;
        if (tipoValorD_by_tipoValor_id != null ? !tipoValorD_by_tipoValor_id.equals(that.tipoValorD_by_tipoValor_id) : that.tipoValorD_by_tipoValor_id != null)
            return false;
        return eventos_by_eventos_code != null ? eventos_by_eventos_code.equals(that.eventos_by_eventos_code) : that.eventos_by_eventos_code == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (id_tipo != null ? id_tipo.hashCode() : 0);
        result = 31 * result + (valor != null ? valor.hashCode() : 0);
        result = 31 * result + (tipoValorD_by_tipoValor_id != null ? tipoValorD_by_tipoValor_id.hashCode() : 0);
        result = 31 * result + (eventos_by_eventos_code != null ? eventos_by_eventos_code.hashCode() : 0);
        return result;
    }

    //RELACIONES

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Id_Tipo", referencedColumnName = "Id", nullable = false,updatable = false,insertable = false )
    public TipoValor getTipoValorD_by_tipoValor_id() {
        return tipoValorD_by_tipoValor_id;
    }

    public void setTipoValorD_by_tipoValor_id(TipoValor tipoValorD_by_tipoValor_id) {
        this.tipoValorD_by_tipoValor_id = tipoValorD_by_tipoValor_id;
    }


    @ManyToMany(mappedBy = "diccionarios_by_diccionarios_code")
    public List<Event> getEventos_by_eventos_code() {
        return eventos_by_eventos_code;
    }

    public void setEventos_by_eventos_code(List<Event> eventos_by_eventos_code) {
        this.eventos_by_eventos_code = eventos_by_eventos_code;
    }
}
