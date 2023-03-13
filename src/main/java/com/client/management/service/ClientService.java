package com.client.management.service;

import com.client.management.dao.ClientDao;
import com.client.management.exceptions.ClientException;
import com.client.management.model.Client;
import com.client.management.util.IdNumberValidator;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class ClientService {

    @Autowired
    private ClientDao clientDao;

    public void createClient(Client client) throws ClientException {
        log.info("Saving client record {}", client);
        if (IdNumberValidator.isSouthAfrican(client.getIdNumber())) {
            log.info("Client passed validation", client);
            try {
                clientDao.save(client);
            } catch (Exception e) {
                throw new ClientException(e.getMessage());
            }
        } else {
            throw new ClientException("Invalid ID number provided");
        }

    }

    public void updateClient(Client client) {
        log.info("Updating client record with {}", client);
        clientDao.save(client);
    }

    public Client searchClientByFirstName(String firstName) {
        log.info("Searching for client by firstname {}", firstName);
        return clientDao.findByFirstName(firstName);
    }

    public Client searchClientByIdNumber(String idNumber) {
        log.info("Searching for client by id number {}", idNumber);
        return clientDao.findByIdNumber(idNumber);
    }

    public Client searchClientByMobileNumber(String mobileNumber) {
        log.info("Searching for client by mobile number {}", mobileNumber);
        return clientDao.findByMobileNumber(mobileNumber);
    }
}
