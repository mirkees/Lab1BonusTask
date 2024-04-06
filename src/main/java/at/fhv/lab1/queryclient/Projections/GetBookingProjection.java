package at.fhv.lab1.queryclient.Projections;

import at.fhv.lab1.eventbus.events.RoomBookedEvent;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.time.format.DateTimeParseException;

import org.springframework.stereotype.Component;

@Component
public class GetBookingProjection {


    private List<RoomBookedEvent> bookedEvents;

    public GetBookingProjection(){
        this.bookedEvents = new ArrayList<>();
    }

    public void addBooking(RoomBookedEvent roomBookedEvent){
        bookedEvents.add(roomBookedEvent);
    }
    public List<RoomBookedEvent> getBookings(String start, String end) {
        LocalDate startDate, endDate;

            startDate = LocalDate.parse(start.trim());
            endDate = LocalDate.parse(end.trim());

        return bookedEvents.stream()
                .filter(event -> !(event.getEnd().isBefore(startDate) || event.getStart().isAfter(endDate)))
                .collect(Collectors.toList());
    }
    
    

}
