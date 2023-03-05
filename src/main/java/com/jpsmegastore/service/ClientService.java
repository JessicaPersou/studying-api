package com.jpsmegastore.service;

import com.jpsmegastore.dto.ClientDTO;
import com.jpsmegastore.model.Client;
import com.jpsmegastore.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService { //classe responsável pela lógica de negócio

    @Autowired
    ClientRepository clientRepository;

    public List<Client> findAllClients(){
       return clientRepository.findAll();
    }

    public Client findById(long id){
        return clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Id não encontrado."));
    }

    public Client crateClient(ClientDTO clientDto){
        Client client = new Client();
        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setBirthdate(clientDto.getBirthdate());
        client.setEmail(clientDto.getEmail());

        return clientRepository.save(client);
    }

    public Client updateClient(Long id, ClientDTO clientDto){
        Optional<Client> clients = clientRepository.findById(id);

            if(clients.isPresent()){
               Client client = clients.get();
               client.setFirstName(clientDto.getFirstName());
               client.setLastName(clientDto.getLastName());
               client.setBirthdate(clientDto.getBirthdate());
               client.setEmail(clientDto.getEmail());

               return clientRepository.save(client);

            }else{
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado.");
            }
    }

    public void deleteClientById(long id){
        clientRepository.deleteById(id);
    }

}
