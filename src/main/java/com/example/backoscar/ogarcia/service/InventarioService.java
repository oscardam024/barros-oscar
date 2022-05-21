package com.example.backoscar.ogarcia.service;

import com.example.backoscar.ogarcia.model.Inventario;
import com.example.backoscar.ogarcia.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventarioService extends BaseService<Inventario,Integer, InventarioRepository> {
    @Autowired
    private InventarioRepository inventarioRepository;

    public Optional<Inventario> setCantidad(Integer id, Integer cantidad){
       Optional<Inventario> item = inventarioRepository.findById(id);
       if (item.isPresent()){
           if((item.get().getCantidad()+cantidad<0)){return null;}
           item.get().setCantidad(item.get().getCantidad()+cantidad);
           return item;
       }
       return null;
    }
}
