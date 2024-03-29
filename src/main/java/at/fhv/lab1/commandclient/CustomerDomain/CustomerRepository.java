package at.fhv.lab1.commandclient.CustomerDomain;




import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;


@Repository
public class CustomerRepository {

        private final List<Customer> customers = new ArrayList<>();


    public Optional<Customer> customer(String customerId){
        return customers.stream().filter(customer -> customer.getCustomerId().equals(customerId)).findFirst();
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
        System.out.println("The Customer with the following name was added to the repository: " + customer.getName());
    }
}
