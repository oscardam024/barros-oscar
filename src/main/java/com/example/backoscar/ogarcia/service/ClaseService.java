package com.example.backoscar.ogarcia.service;

import com.example.backoscar.ogarcia.model.Alumno;
import com.example.backoscar.ogarcia.model.Clase;
import com.example.backoscar.ogarcia.model.Profesor;
import com.example.backoscar.ogarcia.repository.AlumnoRepository;
import com.example.backoscar.ogarcia.repository.ClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClaseService extends BaseService<Clase,Integer, ClaseRepository>{
    @Autowired
    private ClaseRepository claseRepository;
    private AlumnoRepository alumnoRepository;

    public List<Alumno> getAlumnos(Integer id) {
    Optional<Clase> test = claseRepository.findById(id);
     if (test.isPresent()){
        return test.get().getClasesAsignadas();
     }
     return null;
    }
    public Optional<Clase> setAlumnos(List<Alumno> lista, Integer id){
        Optional<Clase> miclase = claseRepository.findById(id);
        if (miclase.isPresent()) {
        miclase.get().setClasesAsignadas(lista);
            return miclase;
        }
        return null;
    }
    public List<Profesor> getProfesores(Integer id) {
        Optional<Clase> test = claseRepository.findById(id);
        if (test.isPresent()){
            return test.get().getPclasesAsignadas();
        }
        return null;
    }
    public Optional<Clase> setProfesores(List<Profesor> lista, Integer id){
        Optional<Clase> miclase = claseRepository.findById(id);
        if (miclase.isPresent()) {
            miclase.get().setPclasesAsignadas(lista);
            return miclase;
        }
        return null;
    }
}
