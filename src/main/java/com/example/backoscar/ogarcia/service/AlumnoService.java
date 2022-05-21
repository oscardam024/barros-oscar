package com.example.backoscar.ogarcia.service;

import com.example.backoscar.ogarcia.model.Alumno;
import com.example.backoscar.ogarcia.model.Clase;
import com.example.backoscar.ogarcia.model.Client;
import com.example.backoscar.ogarcia.repository.AlumnoRepository;
import com.example.backoscar.ogarcia.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService extends BaseService<Alumno,Integer, AlumnoRepository>{
    @Autowired
    private AlumnoRepository alumnoRepository;

    public List<Clase> getClases(Integer id) {
        Optional<Alumno> test = alumnoRepository.findById(id);
        if (test.isPresent()){
            return test.get().getAlumnosAsociados();
        }
        return null;
    }
    public Optional<Alumno> setClases(Integer id){
        Optional<Alumno> mialumno = alumnoRepository.findById(id);
        if (mialumno.isPresent()) {
            return mialumno;
        }
        return null;
    }
}
