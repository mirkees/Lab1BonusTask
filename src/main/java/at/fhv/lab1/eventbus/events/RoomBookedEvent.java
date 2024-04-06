package at.fhv.lab1.eventbus.events;

import java.time.LocalDate;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RoomBookedEvent {
    private String bookingID;
    private String customer;
    private String roomID;
    private String content;
    private LocalDate start;
    private LocalDate end;



    


    @Override
    public String toString() {
        return "RoomBookedEvent{" +
                "bookingID=" + bookingID +
                ", customer='" + customer + '\'' +
                ", roomID=" + roomID +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
