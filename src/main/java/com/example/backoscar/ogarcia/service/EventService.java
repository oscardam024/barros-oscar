package com.example.backoscar.ogarcia.service;

import com.example.backoscar.ogarcia.exception.EventoNotFoundException;
import com.example.backoscar.ogarcia.model.Event;
import com.example.backoscar.ogarcia.repository.EventRepository;
import com.sipios.springsearch.anotation.SearchSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class EventService extends BaseService<Event,Integer, EventRepository>{
    @Autowired
    private EventRepository eventRepository;

    public Page<Event> findAllFiltered(Pageable paginado , @SearchSpec Specification<Event> filtros ){

        return eventRepository.findAll(filtros,paginado);
    }
    public void deleteEventoById(Integer id){
        eventRepository.deleteById(id);
    }
    public Event addEvento(Event evento){
        return eventRepository.save(evento);
    }
    public Event findEventoById(Integer id){
        return eventRepository.findById(id)
                .orElseThrow(()-> new EventoNotFoundException("Evento con id :"+id+" no funciona"));
    }
}
