package com.jpsmegastore.controller;

import com.jpsmegastore.dto.ClientDTO;
import com.jpsmegastore.model.Client;
import com.jpsmegastore.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping
    public List<Client> findAllClients(){
        return clientService.findAllClients();
    }

    @GetMapping("/{id}")
    public Client findById(@PathVariable long id){
        return clientService.findById(id);
    }

    @PostMapping
    public Client createClient(@RequestBody ClientDTO clientDTO){
        return clientService.crateClient(clientDTO);
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable long id, @RequestBody ClientDTO clientDTO){
        return clientService.updateClient(id,clientDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteClientById(@PathVariable long id){
        clientService.deleteClientById(id);
    }
}
