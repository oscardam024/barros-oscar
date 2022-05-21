package com.example.backoscar.ogarcia.service;

import com.example.backoscar.ogarcia.model.Inventario;
import com.example.backoscar.ogarcia.model.Prestamos;
import com.example.backoscar.ogarcia.repository.InventarioRepository;
import com.example.backoscar.ogarcia.repository.PrestamosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamosService  extends BaseService<Prestamos,Integer, PrestamosRepository>{
    @Autowired
    private PrestamosRepository prestamosRepository;




    public List<Prestamos> findFiltro(Boolean filtro) {
        List<Prestamos> prestamos = prestamosRepository.noDevuelto(filtro);

        return prestamos;

    }


}
