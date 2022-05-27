package com.example.backoscar.ogarcia.controller;


import com.example.backoscar.ogarcia.model.Alumno;
import com.example.backoscar.ogarcia.model.Clase;
import com.example.backoscar.ogarcia.model.Profesor;
import com.example.backoscar.ogarcia.service.ProfesorService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@CrossOrigin("*")
@RestController()
public class ProfesorController {
    @Autowired
    private ProfesorService profesorService;
    private final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @GetMapping("/profesores")
    public ResponseEntity<List<Profesor>> listaProfesores() {
        logger.info("inicio listaProfesores");
        List<Profesor> profesores = null;
        profesores = profesorService.findAll();
        logger.info("fin listaProfesores");
        return new ResponseEntity<>(profesores, HttpStatus.OK);
    }
    @GetMapping("/profesores/{id}")
    public ResponseEntity<Profesor> getProfesor(@PathVariable("id")Integer id) throws Exception {
        logger.info("inicio listaProfesores");
        Optional<Profesor> profesor = profesorService.findById(id);
        if(profesor.isPresent()){
            Profesor profesor2 = profesor.orElseThrow(() -> new Exception("No existe el alumno"));
            return new ResponseEntity<>(profesor2, HttpStatus.OK);
        }

        logger.info("fin listaProfesores");
        return null;
    }
    @DeleteMapping(path="/profesores/{id}")
    public ResponseEntity<String> deleteProfesor(@PathVariable("id") Integer id) throws Exception {
        Optional<Profesor> profesoranadido = profesorService.findById(id);
        if(profesoranadido.isPresent()){
            Profesor profesor = profesoranadido.orElseThrow(() -> new Exception("No existe el alumno"));
            profesorService.delete(profesor);
            return new ResponseEntity<>("borrado ejecutado", HttpStatus.OK);
        }
        return new ResponseEntity<>("Error: no se encontro el alumno", HttpStatus.NOT_FOUND);
    }
    @PostMapping(path="/profesores")
    public ResponseEntity<Profesor> addProfesor(@RequestBody Profesor profesor) {
        Profesor addprofe = profesorService.save(profesor);
        return new ResponseEntity<>(addprofe, HttpStatus.OK);
    }
    @PutMapping(path="/profesores")
    public ResponseEntity<String> editProfesor(@RequestBody Profesor profesor) {
        Optional<Profesor> profe = profesorService.findById(profesor.getIdProfesor());
        if(profe.isPresent()){
            profesorService.edit(profesor);
            return new ResponseEntity<>("Profesor editado con exito", HttpStatus.OK);
        }

        return new ResponseEntity<>("Error, no se ha encontrado el profesor", HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/profesores/clases/{id}")
    public ResponseEntity<List<Clase>> listaClases(@PathVariable("id") Integer id) {
        List<Clase> clases = null;
        clases = profesorService.getClases(id);
        return new ResponseEntity<>(clases, HttpStatus.OK);
    }
    @PutMapping(path="/profesores/clases/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Clase>> addlistaClases(@RequestBody List<Clase> lista, @PathVariable("id") Integer id) {
        Optional<Profesor> test = profesorService.setClases(id);
        if(test.isPresent()){
            test.get().setProfesoresAsociados(lista);
            profesorService.edit(test.get());
            return new ResponseEntity(test.get().getProfesoresAsociados(), HttpStatus.OK);
        }
        return null;
    }

}
