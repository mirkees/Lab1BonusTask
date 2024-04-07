package at.fhv.lab1.eventbus.events;

import lombok.*;



@Getter
@Setter
public class CancelBookingEvent {


    private String roomNumber;
    private String name;
}
