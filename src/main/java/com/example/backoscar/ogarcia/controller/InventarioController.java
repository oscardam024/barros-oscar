package com.example.backoscar.ogarcia.controller;

import com.example.backoscar.ogarcia.model.Inventario;
import com.example.backoscar.ogarcia.model.Profesor;
import com.example.backoscar.ogarcia.service.InventarioService;
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
public class InventarioController {
    @Autowired
    private InventarioService inventarioService;
    private final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @GetMapping("/items")
    public ResponseEntity<List<Inventario>> listaItems() {
        logger.info("inicio listaItems");
        List<Inventario> items = null;
        items = inventarioService.findAll();
        logger.info("fin listaProfesores");
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
    @PostMapping(path="/items")
    public ResponseEntity<Inventario> addItem(@RequestBody Inventario item) {
        Inventario addItem = inventarioService.save(item);
        return new ResponseEntity<>(addItem, HttpStatus.OK);
    }
    @DeleteMapping(path="/items/delete/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable("id") Integer id) {
        Optional<Inventario> item = inventarioService.findById(id);
        if(item.isPresent()){
            inventarioService.delete(item.get());
            return new ResponseEntity<>("Item borrado correctamente", HttpStatus.OK);
        }
        return new ResponseEntity<>("Error: Item no encontrado", HttpStatus.NOT_FOUND);
    }
    @PostMapping(path="/items/edit")
    public ResponseEntity<Inventario> editItem(@RequestBody Inventario item) {
        Inventario addItem = inventarioService.edit(item);
        return new ResponseEntity<>(addItem, HttpStatus.OK);
    }

    @PostMapping(path="/items/addstock/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer>numeroITems(@RequestBody Integer cantidad, @PathVariable("id") Integer id){
       Optional<Inventario> item = inventarioService.setCantidad(id,cantidad);
       if(item.isPresent()){
           inventarioService.save(item.get());
           return new ResponseEntity(item.get().getCantidad(), HttpStatus.OK);
       }
       return null;
    }
}
