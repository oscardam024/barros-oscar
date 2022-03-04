package com.example.backoscar.ogarcia.repository;

import com.example.backoscar.ogarcia.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EventRepository extends JpaRepository<Event, Integer> , JpaSpecificationExecutor<Event> {
}
