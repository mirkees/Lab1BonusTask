package at.fhv.lab1.commandclient.CustomerDomain;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class Customer {


    private String name;
    private String customerId;

    public Customer(String name, String customerId){
        this.name = name;
        this.customerId = customerId;
    }
}
