package at.fhv.lab1;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCustomerCommand {
    private String name;
    private String address;
    private LocalDate dateOfBirth;

    // Konstruktor, Getter und Setter
}
