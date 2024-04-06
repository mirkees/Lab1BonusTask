package at.fhv.lab1.queryclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import at.fhv.lab1.eventbus.events.RoomBookedEvent;
import at.fhv.lab1.queryclient.Projections.GetBookingProjection;

import java.time.LocalDate;
import java.util.*;

@RestController
public class QueryRestController {


    private final GetBookingProjection getBookingProjection;

    public QueryRestController(GetBookingProjection getBookingProjection) {
        this.getBookingProjection = getBookingProjection;

    }

    @PostMapping(value = "/roombookedevent", consumes = "application/json")
    public boolean addEvent(@RequestBody RoomBookedEvent event) {
        System.out.println("Event received: " + event);
        // TODO: process event through projection
        getBookingProjection.addBooking(event);
        return true;
    }

    @GetMapping("/bookings")
    public List <RoomBookedEvent> getBookings(@RequestParam String start, @RequestParam String end){
        System.out.println("This is the start"+ start);
        List<RoomBookedEvent> bookings = getBookingProjection.getBookings(start, end);

        bookings.forEach(System.out::println);
        
        return bookings;
    }
}
