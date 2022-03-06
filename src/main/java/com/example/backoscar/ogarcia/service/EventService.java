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

    public Page<Event> getEventos(Pageable pageable, @SearchSpec Specification<Event> specs) {
        return eventRepository.findAll(specs, pageable);
    }
    public void deleteEventoById(Integer id){
        eventRepository.deleteById(id);
    }
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }
    public Event editarEventbyId(Integer id, Event evento) {
        Event event = eventRepository.findById(id).orElse(evento);
        evento.setIdEvento(event.getIdEvento());

        return eventRepository.save(evento);
    }
    public Event findEventoById(Integer id){
        return eventRepository.findById(id)
                .orElseThrow(()-> new EventoNotFoundException("Evento con id :"+id+" no funciona"));
    }

}
