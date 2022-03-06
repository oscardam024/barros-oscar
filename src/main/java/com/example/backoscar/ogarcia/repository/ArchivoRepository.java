package com.example.backoscar.ogarcia.repository;

import com.example.backoscar.ogarcia.model.Archivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArchivoRepository extends JpaRepository<Archivo,Integer> {
}
