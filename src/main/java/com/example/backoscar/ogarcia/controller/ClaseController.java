package com.example.backoscar.ogarcia.controller;

import com.example.backoscar.ogarcia.model.Alumno;
import com.example.backoscar.ogarcia.model.Clase;
import com.example.backoscar.ogarcia.model.Profesor;
import com.example.backoscar.ogarcia.service.ClaseService;
import lombok.extern.slf4j.Slf4j;
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
public class ClaseController {
    @Autowired
    private ClaseService claseService;
    @GetMapping("/clases")
    public ResponseEntity<List<Clase>> listaClases() {
        List<Clase> clases = null;
        clases = claseService.findAll();
        return new ResponseEntity<>(clases, HttpStatus.OK);
    }
    @GetMapping("/clase/{id}")
    public ResponseEntity<Clase> getClase(@PathVariable("id") Integer id) {
        Optional<Clase> clase = null;
        clase = claseService.findById(id);
        return new ResponseEntity(clase, HttpStatus.OK);
    }
    @PostMapping(path="/clases", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Clase> addClase(@RequestBody Clase clase) {
        Clase claseanadida = claseService.save(clase);
        return new ResponseEntity<>(claseanadida, HttpStatus.OK);
    }
    @DeleteMapping(path="/clases/{id}")
    public ResponseEntity<String> deleteClase(@PathVariable("id") Integer id) {
        Optional<Clase> clase = claseService.findById(id);
            if(clase.isPresent()){
                claseService.delete(clase.get());
                return new ResponseEntity<>("clase borrada con exito", HttpStatus.OK);
            }
        return new ResponseEntity<>("Error: Clase no encontrada", HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/clases/alumnos/{id}")
    public ResponseEntity<List<Alumno>> listaAlumnos(@PathVariable("id") Integer id) {
        List<Alumno> alumnos = null;
        alumnos = claseService.getAlumnos(id);
        return new ResponseEntity<>(alumnos, HttpStatus.OK);
    }
    @PostMapping(path="/clases/alumnos/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Alumno>> addlistaAlumnos(@RequestBody List<Alumno> lista, @PathVariable("id") Integer id) {

            Optional<Clase> test = claseService.setAlumnos(lista, id);
            if(test.isPresent()){
                claseService.save(test.get());
                return new ResponseEntity(test.get().getClasesAsignadas(), HttpStatus.OK);
            }
            return null;
    }
    @PutMapping(path="/clases/alumnos/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Alumno>> editlistaAlumnos(@RequestBody List<Alumno> lista, @PathVariable("id") Integer id) {

        Optional<Clase> test = claseService.setAlumnos(lista, id);
        if(test.isPresent()){
            claseService.edit(test.get());
            return new ResponseEntity(test.get().getClasesAsignadas(), HttpStatus.OK);
        }
        return null;
    }
    @GetMapping("/clases/profesores/{id}")
    public ResponseEntity<List<Profesor>> listaProfesores(@PathVariable("id") Integer id) {
        List<Profesor> profesores = null;
        profesores = claseService.getProfesores(id);
        return new ResponseEntity<>(profesores, HttpStatus.OK);
    }
    @PostMapping(path="/clases/profesores/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Profesor>> addlistaProfesores(@RequestBody List<Profesor> lista, @PathVariable("id") Integer id) {
        Optional<Clase> test = claseService.setProfesores(lista, id);
        if(test.isPresent()){
            claseService.save(test.get());
            return new ResponseEntity(test.get().getPclasesAsignadas(), HttpStatus.OK);
        }
        return null;
    }

}
