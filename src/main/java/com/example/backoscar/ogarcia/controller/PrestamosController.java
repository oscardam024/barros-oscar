package com.example.backoscar.ogarcia.controller;

import com.example.backoscar.ogarcia.model.Incidencia;
import com.example.backoscar.ogarcia.model.Inventario;
import com.example.backoscar.ogarcia.model.Prestamos;
import com.example.backoscar.ogarcia.model.Profesor;
import com.example.backoscar.ogarcia.repository.InventarioRepository;
import com.example.backoscar.ogarcia.service.InventarioService;
import com.example.backoscar.ogarcia.service.PrestamosService;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
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
public class PrestamosController {
    @Autowired
    public InventarioService inventarioService;
    @Autowired
    private PrestamosService prestamosService;
    private final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @GetMapping("/prestamos")
    public ResponseEntity<List<Prestamos>> listaPrestamos() {
        logger.info("inicio listaPrestamos");
        List<Prestamos> prestamos = null;
        prestamos = prestamosService.findAll();
        logger.info("fin listaPrestamos");
        return new ResponseEntity<>(prestamos, HttpStatus.OK);
    }

    @PostMapping(path = "/prestamo")
    public ResponseEntity<Prestamos> addPrestamo(@NotNull @RequestBody Prestamos prestamo) throws Exception {
        Optional<Inventario> item = inventarioService.findById(prestamo.getItem().getIdItem());
        if (item.isPresent()) {
            if (!((item.get().getCantidad() - prestamo.getCantidad()) < 0)) {
                Inventario inventario = item.orElseThrow(() -> new Exception("No existe el item"));
                inventario.setCantidad(inventario.getCantidad()-prestamo.getCantidad());
                prestamo.getItem().setCantidad(inventario.getCantidad()-prestamo.getCantidad());
                inventarioService.save(inventario);
                prestamosService.save(prestamo);
                return new ResponseEntity<>(prestamo, HttpStatus.OK);
            }

        }
        return null;


    }

    @PostMapping("/prestamos/filtro")
    public ResponseEntity<List<Prestamos>> listaPrestamos(@RequestBody Boolean filtro) {
        List<Prestamos> prestamos = null;
        prestamos = prestamosService.findFiltro(filtro);
        if (!prestamos.isEmpty()) {
            return new ResponseEntity<>(prestamos, HttpStatus.OK);
        }
        return null;
    }
}
