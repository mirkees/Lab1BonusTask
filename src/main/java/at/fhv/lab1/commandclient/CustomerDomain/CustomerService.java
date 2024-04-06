package at.fhv.lab1.commandclient.CustomerDomain;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.fhv.lab1.commandclient.BookRoomCommand;

@Service
public class CustomerService {

    @Autowired
    public CustomerRepository customerRepository;

    public boolean customerExists(BookRoomCommand command){
        Optional<Customer> existingCustomers = customerRepository.customer(command.getCustomerId());
        
        if (existingCustomers.isPresent()) {
            Customer customer = existingCustomers.get();
            if (customer.getCustomerId().contains(command.getCustomerId())) {
                return true;
            } 
        } 
        return false;
    }


}
