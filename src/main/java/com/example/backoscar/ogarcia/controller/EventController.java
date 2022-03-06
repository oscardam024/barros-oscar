package com.example.backoscar.ogarcia.controller;

import com.example.backoscar.ogarcia.model.Event;
import com.example.backoscar.ogarcia.service.EventService;
import com.sipios.springsearch.anotation.SearchSpec;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin("*")
@RestController()
public class EventController {
    private EventService eventService;
    @GetMapping(value = "eventos/lista/")
    public ResponseEntity<Page<Event>> listaEventos(@SearchSpec Specification<Event> filtros,
                                                    @PageableDefault(size = 5, page = 0) @RequestBody Pageable pagina){
        Page<Event> eventos = null;
        eventos = eventService.findAllFiltered(pagina,filtros);
        return new ResponseEntity<>(eventos, HttpStatus.OK);
    }
    @DeleteMapping("eventos/eliminar/{id}")
    public ResponseEntity<Event> dellEventoById(@PathVariable("id") Integer id){
        Event dellEvento = eventService.findEventoById(id);
        eventService.deleteEventoById(id);
        return new ResponseEntity<>(dellEvento,HttpStatus.OK);
    }
    @PutMapping("eventos/modificar")
    public ResponseEntity<Event> updateEvento(@RequestBody Event evento){
        Event modEvento = eventService.edit(evento);
        return new ResponseEntity<>(modEvento, HttpStatus.OK);
    }
    @PostMapping("eventos/add")
    public ResponseEntity<Event> addEvento(@RequestBody Event evento){
        Event addEvento = eventService.addEvento(evento);
        return new ResponseEntity<>(addEvento, HttpStatus.OK);
    }
    @GetMapping("eventos/find/{id}")
    public ResponseEntity<Event> findEventoById(@PathVariable("id") Integer id){
        Event evento = eventService.findEventoById(id);
        return new ResponseEntity<>(evento, HttpStatus.OK);
    }
}
