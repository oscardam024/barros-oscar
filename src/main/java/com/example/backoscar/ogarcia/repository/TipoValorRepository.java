package com.example.backoscar.ogarcia.repository;

import com.example.backoscar.ogarcia.model.TipoValor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoValorRepository extends JpaRepository<TipoValor,Integer> {
}
