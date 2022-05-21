package com.example.backoscar.ogarcia.repository;

import com.example.backoscar.ogarcia.model.Incidencia;
import com.example.backoscar.ogarcia.model.Prestamos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PrestamosRepository extends JpaRepository<Prestamos,Integer> {
    @Query("SELECT p FROM Prestamos p WHERE p.devuelto = :filtro")
    List<Prestamos> noDevuelto(@Param("filtro")Boolean filtro);
}
