package at.fhv.lab1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import at.fhv.lab1.commandclient.BookingDomain.Room;
import at.fhv.lab1.commandclient.BookingDomain.RoomRepository;
import at.fhv.lab1.commandclient.CustomerDomain.Customer;
import at.fhv.lab1.commandclient.CustomerDomain.CustomerRepository;






@SpringBootApplication
@Configuration
@ComponentScan({"at.fhv.lab1.commandclient"})
public class CommandClientApplicationTest {


    private final RoomRepository roomRepository;
    private final CustomerRepository customerRepository;

    public CommandClientApplicationTest(RoomRepository roomRepository, CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
        this.roomRepository = roomRepository;
    }

        public static void main(String[] args) {
        SpringApplication.run(CommandClientApplicationTest.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            Customer markus = new Customer("markus", "12");
            Customer erik = new Customer("erik", "13");
            customerRepository.addCustomer(markus);
            customerRepository.addCustomer(erik);


            Room room1 = new Room("1");
            Room room2 = new Room("2");
            roomRepository.addRoom(room2);
            roomRepository.addRoom(room1);
        };
    }


}
