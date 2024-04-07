package at.fhv.lab1.commandclient;


import lombok.*;


@Getter
@Setter
@AllArgsConstructor
public class CancelBookingCommand {

    private String roomNumber;
    private String content;
    private String name;

}
