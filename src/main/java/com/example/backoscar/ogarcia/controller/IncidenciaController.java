package com.example.backoscar.ogarcia.controller;

import com.example.backoscar.ogarcia.model.Incidencia;
import com.example.backoscar.ogarcia.model.Profesor;
import com.example.backoscar.ogarcia.service.IncidenciaService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@CrossOrigin("*")
@RestController()
public class IncidenciaController {
    @Autowired
    private IncidenciaService incidenciaService;
    private final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @GetMapping("/incidencias")
    public ResponseEntity<List<Incidencia>> listaIncidencias() {
        logger.info("inicio listaIncidencias");
        List<Incidencia> incidencias = null;
        incidencias = incidenciaService.findAll();
        logger.info("fin listaIncidencias");
        return new ResponseEntity<>(incidencias, HttpStatus.OK);
    }
    @PostMapping(path="/incidencias")
    public ResponseEntity<Incidencia> addIncidencia(@RequestBody Incidencia incidencia) {
        Incidencia addIncidencia = incidenciaService.save(incidencia);
        return new ResponseEntity<>(addIncidencia, HttpStatus.OK);
    }
    @PostMapping(path="/incidencias/solucionar/{id}")
    public ResponseEntity<Incidencia> solucionarIncidencia(@PathVariable("id") Integer id) {
        Optional<Incidencia> incidencia = incidenciaService.findById(id);
        if(incidencia.isPresent()){
            incidencia.get().setResuelta(true);
            incidenciaService.save(incidencia.get());
            return new ResponseEntity<>(incidencia.get(), HttpStatus.OK);
        }
        return null;
    }
    @PostMapping("/incidencias/filtro")
    public ResponseEntity<List<Incidencia>> listaIncidencias(@RequestBody Boolean filtro) {
        List<Incidencia> incidencias = null;
        incidencias = incidenciaService.findFiltrado(filtro);
        if(!incidencias.isEmpty()){
            return new ResponseEntity<>(incidencias, HttpStatus.OK);
        }
        return null;
    }
}
