package com.example.backoscar.ogarcia.model;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TIPO_VALOR")
public class TipoValor {

    private Integer id;
    private String nombre_tipo;


    @JsonIgnore
    private List<Archivo> archivo_by_Code;

    @Id
    @Column(name = "Id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Nombre_Tipo")
    public String getNombre_tipo() {
        return nombre_tipo;
    }

    public void setNombre_tipo(String nombre_tipo) {
        this.nombre_tipo = nombre_tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoValor)) return false;

        TipoValor that = (TipoValor) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nombre_tipo != null ? !nombre_tipo.equals(that.nombre_tipo) : that.nombre_tipo != null) return false;

        return archivo_by_Code != null ? archivo_by_Code.equals(that.archivo_by_Code) : that.archivo_by_Code == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nombre_tipo != null ? nombre_tipo.hashCode() : 0);
        result = 31 * result + (archivo_by_Code != null ? archivo_by_Code.hashCode() : 0);
        return result;
    }

    //RELACIONES

    @OneToMany(mappedBy = "tipoValorA_by_tipoValor_id", fetch = FetchType.LAZY)

    public List<Archivo> getArchivo_by_Code() {
        return archivo_by_Code;
    }

    public void setArchivo_by_Code(List<Archivo> archivo_by_Code) {
        this.archivo_by_Code = archivo_by_Code;
    }
}
