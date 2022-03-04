package com.example.backoscar.ogarcia.service;

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

}
