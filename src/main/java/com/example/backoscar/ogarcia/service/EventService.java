package com.example.backoscar.ogarcia.service;

import com.example.backoscar.ogarcia.model.Event;
import com.example.backoscar.ogarcia.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService extends BaseService<Event,Integer, EventRepository>{


}
