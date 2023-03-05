package com.jpsmegastore.dto;

import com.jpsmegastore.model.Address;
import com.jpsmegastore.model.Client;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private Date birthdate;
    private String email;
    private List<Address> addresses = new ArrayList<>();


    ClientDTO(Client client){
        this.id = client.getId();
        this.firstName = client.getFirstName();
        this.lastName = client.getLastName();
        this.birthdate = client.getBirthdate();
        this.email = client.getEmail();
        this.addresses = client.getAddresses();
    }
}
