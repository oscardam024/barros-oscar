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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@CrossOrigin("*")
@RestController()
public class EventController {
    private EventService eventService;
    @GetMapping(value = "/lista/")
    public ResponseEntity<Page<Event>> listaEventos(@SearchSpec Specification<Event> filtros,
                                                    @PageableDefault(size = 5, page = 0) @RequestBody Pageable pagina){
        Page<Event> eventos = null;
        eventos = eventService.findAllFiltered(pagina,filtros);
        return new ResponseEntity<>(eventos, HttpStatus.OK);
    }
}
