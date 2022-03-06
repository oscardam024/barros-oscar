package com.example.backoscar.ogarcia.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ARCHIVO")
public class Archivo {



    private Integer id;
    private Integer id_tipo;
    private String ruta;
    private String observable;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private TipoValor tipoValorA_by_tipoValor_id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
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
    @Column(name = "Ruta")
    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    @Basic
    @Column(name = "Observable")
    public String getObservable() {
        return observable;
    }

    public void setObservable(String observable) {
        this.observable = observable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Archivo)) return false;

        Archivo that = (Archivo) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (id_tipo != null ? !id_tipo.equals(that.id_tipo) : that.id_tipo != null) return false;
        if (ruta != null ? !ruta.equals(that.ruta) : that.ruta != null) return false;
        if (observable != null ? !observable.equals(that.observable) : that.observable != null) return false;
        if (tipoValorA_by_tipoValor_id != null ? !tipoValorA_by_tipoValor_id.equals(that.tipoValorA_by_tipoValor_id) : that.tipoValorA_by_tipoValor_id != null)
            return false;
        return eventos_by_eventos_code != null ? eventos_by_eventos_code.equals(that.eventos_by_eventos_code) : that.eventos_by_eventos_code == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (id_tipo != null ? id_tipo.hashCode() : 0);
        result = 31 * result + (ruta != null ? ruta.hashCode() : 0);
        result = 31 * result + (observable != null ? observable.hashCode() : 0);
        result = 31 * result + (tipoValorA_by_tipoValor_id != null ? tipoValorA_by_tipoValor_id.hashCode() : 0);
        result = 31 * result + (eventos_by_eventos_code != null ? eventos_by_eventos_code.hashCode() : 0);
        return result;
    }

    //RELACIONES
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Id_Tipo", referencedColumnName = "Id", updatable = false,insertable = false )
    public TipoValor getTipoValorA_by_tipoValor_id() {
        return tipoValorA_by_tipoValor_id;
    }

    public void setTipoValorA_by_tipoValor_id(TipoValor tipoValorA_by_tipoValor_id) {
        this.tipoValorA_by_tipoValor_id = tipoValorA_by_tipoValor_id;
    }



    @ManyToMany(mappedBy = "archivos_by_archivos_code")
    public List<Event> getEventos_by_eventos_code() {
        return eventos_by_eventos_code;
    }

    public void setEventos_by_eventos_code(List<Event> eventos_by_eventos_code) {
        this.eventos_by_eventos_code = eventos_by_eventos_code;
    }


}
