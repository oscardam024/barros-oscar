package com.example.backoscar.ogarcia.service;

import com.example.backoscar.ogarcia.model.Incidencia;
import com.example.backoscar.ogarcia.repository.IncidenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncidenciaService extends BaseService<Incidencia,Integer, IncidenciaRepository> {
    @Autowired
    private IncidenciaRepository incidenciaRepository;


    public List<Incidencia> findFiltrado(Boolean filtro) {
        List<Incidencia> incidencias = incidenciaRepository.noResueltas(filtro);

            return incidencias;

    }
}
