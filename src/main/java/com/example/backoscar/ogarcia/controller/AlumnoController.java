package com.example.backoscar.ogarcia.controller;

import com.example.backoscar.ogarcia.model.Alumno;
import com.example.backoscar.ogarcia.model.Clase;
import com.example.backoscar.ogarcia.model.Client;
import com.example.backoscar.ogarcia.service.AlumnoService;
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
public class AlumnoController {
    @Autowired
    private AlumnoService alumnoService;
    private final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @GetMapping("/alumnos")
    public ResponseEntity<List<Alumno>> listaAlumnos() {
        logger.info("inicio listaAlumnos");
        List<Alumno> alumnos = null;

        alumnos = alumnoService.findAll();
        logger.info("fin listaClientes");
        return new ResponseEntity<>(alumnos, HttpStatus.OK);
    }
    @PutMapping(path="/alumnos")
    public ResponseEntity<String> editAlumno(@RequestBody Alumno alumno) {
        Optional<Alumno>alumnoedit = alumnoService.findById(alumno.getIdAlumno());
        if(alumnoedit.isPresent()){
            alumnoService.save(alumno);
            return new ResponseEntity<>("Alumno añadido con éxito", HttpStatus.OK);
        }
        return new ResponseEntity<>("Alumno no encontrado", HttpStatus.BAD_REQUEST);

    }
    @PostMapping(path="/alumnos")
    public ResponseEntity<Alumno> addAlumno(@RequestBody Alumno alumno) {
        Alumno alumnoanadido = alumnoService.save(alumno);
        return new ResponseEntity<>(alumnoanadido, HttpStatus.OK);
    }
    @DeleteMapping(path="/alumnos")
    public ResponseEntity<String> deleteAlumno(@RequestBody Alumno alumno) {
        Optional<Alumno> alumnoanadido = alumnoService.findById(alumno.getIdAlumno());
        if(alumnoanadido.isPresent()){
            alumnoService.delete(alumno);
            return new ResponseEntity<>("borrado ejecutado", HttpStatus.OK);
        }
        return new ResponseEntity<>("Error: no se encontro el alumno", HttpStatus.NOT_FOUND);
    }
    @GetMapping("/alumnos/clases/{id}")
    public ResponseEntity<List<Clase>> listaClases(@PathVariable("id") Integer id) {
        List<Clase> clases = null;
        clases = alumnoService.getClases(id);
        return new ResponseEntity<>(clases, HttpStatus.OK);
    }
    @PutMapping(path="/alumnos/clases/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Clase>> editlistaClases(@RequestBody List<Clase> lista, @PathVariable("id") Integer id) {

        Optional<Alumno> test = alumnoService.setClases(id);
        if(test.isPresent()){
            test.get().setAlumnosAsociados(lista);
            alumnoService.edit(test.get());
            return new ResponseEntity(test.get().getAlumnosAsociados(), HttpStatus.OK);
        }
        return null;
    }
}
