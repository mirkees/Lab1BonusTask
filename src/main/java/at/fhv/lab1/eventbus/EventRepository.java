package at.fhv.lab1.eventbus;

import at.fhv.lab1.eventbus.events.Event;
import at.fhv.lab1.eventbus.events.RoomBookedEvent;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class EventRepository {

    private static final Logger logger = LoggerFactory.getLogger("EventLogger");
    private final EventPublisher eventPublisher;

    public EventRepository(EventPublisher eventPublisher){
        this.eventPublisher = eventPublisher;
    }

    private final List<Event> events = new ArrayList<>();
    private final List<RoomBookedEvent> rbEvents = new ArrayList<>();

    public void processEvent(Event event) {
        // TODO: store events in log/DB
        logger.info("Processing Event: {}", event);
        events.add(event);

        // TODO: notify subscribed read repositories
        eventPublisher.publishEvent(event);
        System.out.println("Processing Event");
    }


    public void processEvent(RoomBookedEvent event) {
        // TODO: store events in log/DB
        logger.info("Processing Event: {}", event);
        rbEvents.add(event);
        // TODO: notify subscribed read repositories
        eventPublisher.publishEvent(event);
        System.out.println("Processing Room booked Event");
    }


}
