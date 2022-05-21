package com.example.backoscar.ogarcia.service;

import com.example.backoscar.ogarcia.model.Alumno;
import com.example.backoscar.ogarcia.model.Clase;
import com.example.backoscar.ogarcia.model.Profesor;
import com.example.backoscar.ogarcia.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService extends BaseService<Profesor,Integer, ProfesorRepository> {
    @Autowired
    private ProfesorRepository profesorRepository;

    public List<Clase> getClases(Integer id) {
        Optional<Profesor> test = profesorRepository.findById(id);
        if (test.isPresent()){
            return test.get().getProfesoresAsociados();
        }
        return null;
    }
    public Optional<Profesor> setClases(Integer id){
        Optional<Profesor> miprofesor = profesorRepository.findById(id);
        if (miprofesor.isPresent()) {
            return miprofesor;
        }
        return null;
    }
}
