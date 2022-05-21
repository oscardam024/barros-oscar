package com.example.backoscar.ogarcia.repository;

import com.example.backoscar.ogarcia.model.Incidencia;
import com.example.backoscar.ogarcia.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InventarioRepository extends JpaRepository<Inventario,Integer> {


}
