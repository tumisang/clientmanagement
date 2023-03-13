package com.client.management.controller;


import com.client.management.exceptions.ClientException;
import com.client.management.model.Client;
import com.client.management.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/create")
    public ResponseEntity<String> createClient(@RequestBody Client client) {
        try {
            clientService.createClient(client);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ClientException clientException) {
            return new ResponseEntity<>(clientException.getMessage(), HttpStatus.OK);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<Client> updateClient(@RequestBody Client client) {
        clientService.updateClient(client);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search/firstname/{firstName}")
    public ResponseEntity<Client> searchClientByFirstName(@PathVariable("firstName") String firstName) {
        Client client = clientService.searchClientByFirstName(firstName);
        if (client != null) {
            return new ResponseEntity<>(client, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search/mobilenumber/{mobilenumber}")
    public ResponseEntity<Client> searchClientByMobileNumber(@PathVariable("mobilenumber") String mobileNumber) {
        Client client = clientService.searchClientByMobileNumber(mobileNumber);
        if (client != null) {
            return new ResponseEntity<>(client, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search/idnumber/{idnumber}")
    public ResponseEntity<Client> searchClientByIdNumber(@PathVariable("idnumber") String idnumber) {
        Client client = clientService.searchClientByIdNumber(idnumber);
        if (client != null) {
            return new ResponseEntity<>(client, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
