package at.fhv.lab1.commandclient;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import at.fhv.lab1.eventbus.events.Event;
import at.fhv.lab1.eventbus.events.RoomBookedEvent;
import at.fhv.lab1.commandclient.BookingDomain.BookingService;
import at.fhv.lab1.commandclient.CustomerDomain.CustomerService;

@RestController
public class commandRestController {

    private final BookingService bookingService;
    private final CustomerService customerService;
    private final ClientEventPublisher clientPublisher;


    public commandRestController (BookingService bookingService, CustomerService customerService, ClientEventPublisher clientPublisher){
        this.bookingService = bookingService;
        this.customerService = customerService;
        this.clientPublisher = clientPublisher;
    }

    @PostMapping(value = "/bookRoom", consumes = "application/json")
    public ResponseEntity<?> bookRoom(@RequestBody BookRoomCommand command){


        try{
            
            if(bookingService.bookRoom(command) && customerService.customerExists(command)){

                RoomBookedEvent rb = new RoomBookedEvent();
                rb.setBookingID(command.getBookingId());
                rb.setCustomer(command.getName());
                rb.setRoomID(command.getRoomNumber());
                rb.setStart(command.getStart());
                rb.setEnd(command.getEnd());
                
        
                Event event = new Event();
                event.setContent(command.getContent());
                event.setCustomer(command.getName());
                event.setTimestamp(System.currentTimeMillis());
        

                clientPublisher.publishEvent(rb);
                clientPublisher.publishEvent(event);
            }
            return ResponseEntity.ok().build();
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
