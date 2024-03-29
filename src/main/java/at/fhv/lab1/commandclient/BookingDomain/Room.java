package at.fhv.lab1.commandclient.BookingDomain;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Room {
    private String roomNumber;
    private List<LocalDate> bookedDates;



    public Room(String roomNumber) {
        this.roomNumber = roomNumber;
        this.bookedDates = new ArrayList<>();
    }
}