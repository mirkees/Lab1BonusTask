package at.fhv.lab1.commandclient;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import at.fhv.lab1.commandclient.BookingDomain.BookRoomCommand;
import at.fhv.lab1.commandclient.BookingDomain.BookingService;
import at.fhv.lab1.commandclient.CustomerDomain.CustomerService;

@RestController
public class commandRestController {

    private final BookingService bookingService;
    private final CustomerService customerService;


    public commandRestController (BookingService bookingService, CustomerService customerService){
        this.bookingService = bookingService;
        this.customerService = customerService;
    }

    @PostMapping(value = "/bookRoom", consumes = "application/json")
    public ResponseEntity<?> bookRoom(@RequestBody BookRoomCommand command){
        try{
            
            if(bookingService.bookRoom(command) && customerService.customerExists(command)){
                System.out.println("Succes");
            }
            return ResponseEntity.ok().build();
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Room is already booked, try again with other date");
        }
    }
}
