package com.example.backoscar.ogarcia.controller;

import com.example.backoscar.ogarcia.model.Event;
import com.example.backoscar.ogarcia.service.EventService;
import com.sipios.springsearch.anotation.SearchSpec;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin("*")
@RestController()
public class EventController {
    @Autowired
    private EventService eventService;
    @GetMapping(path = "eventos/listEventsPaginated")
    public List<Event> listEventsPaginated(@PageableDefault(size = 5) Pageable pageable, @SearchSpec Specification<Event> specs) {
        Page<Event> response;
        response = eventService.getEventos(pageable, specs);

        return response.getContent();
    }
    @DeleteMapping("eventos/eliminar/{id}")
    public ResponseEntity<Event> dellEventoById(@PathVariable("id") Integer id){
        Event dellEvento = eventService.findEventoById(id);
        eventService.deleteEventoById(id);
        return new ResponseEntity<>(dellEvento,HttpStatus.OK);
    }
    @PutMapping("eventos/editarbyID/{id}")
    public ResponseEntity<Event> editEventById(@PathVariable Integer id, @RequestBody Event newEvent) {
        Event addedEvent = eventService.editarEventbyId(id, newEvent);

        return new ResponseEntity<>(addedEvent, HttpStatus.OK);
    }
    @PostMapping(path = "eventos/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Event> addEvent(@RequestBody Event newEvent) {
        Event addedEvent = eventService.createEvent(newEvent);
        return new ResponseEntity<>(addedEvent, HttpStatus.OK);
    }
    @GetMapping("eventos/findbyId/{id}")
    public ResponseEntity<Event> findEventoById(@PathVariable("id") Integer id){
        Event evento = eventService.findEventoById(id);
        return new ResponseEntity<>(evento, HttpStatus.OK);
    }
}
