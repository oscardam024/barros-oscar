package com.example.backoscar.ogarcia.repository;

import com.example.backoscar.ogarcia.model.Incidencia;
import com.example.backoscar.ogarcia.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IncidenciaRepository extends JpaRepository<Incidencia,Integer> {

    @Query("SELECT i FROM Incidencia i WHERE i.resuelta = :filtro")
    List<Incidencia> noResueltas(@Param("filtro")Boolean filtro);
}
