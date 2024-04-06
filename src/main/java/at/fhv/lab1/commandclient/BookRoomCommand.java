package at.fhv.lab1.commandclient;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookRoomCommand {
    private String roomNumber;
    private String customerId;
    private LocalDate start;
    private LocalDate end;
    private String name;
    private String bookingId;
    private String content;

    @Override
    public String toString() {
        return "Event{" +
                "room Number='" + roomNumber + '\'' +
                ", customerId=" + customerId +
                ", end='" + end + '\'' +
                ", start='" + start + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
