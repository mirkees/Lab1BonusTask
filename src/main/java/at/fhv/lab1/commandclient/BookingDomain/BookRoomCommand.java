package at.fhv.lab1.commandclient.BookingDomain;

import java.time.LocalDate;

import jakarta.validation.OverridesAttribute;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookRoomCommand {
    private String roomNumber;
    private String customerId;
    private LocalDate date;
    private String name;

    @Override
    public String toString() {
        return "Event{" +
                "room Number='" + roomNumber + '\'' +
                ", customerId=" + customerId +
                ", Date='" + date + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
