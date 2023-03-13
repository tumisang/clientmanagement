package com.client.management.service;

import com.client.management.dao.ClientDao;
import com.client.management.exceptions.ClientException;
import com.client.management.model.Address;
import com.client.management.model.Client;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ClientServiceTest {

    @Mock
    private ClientDao clientDao;

    @Autowired
    private ClientService clientService;

    @Test
    public void testSuccessClientCreationService() {
        Client client = Client.builder()
                .firstName("Tumisang")
                .lastName("Maboa")
                .mobileNumber("0123456789d")
                .idNumber("9301205582086")
                .physicalAddress(Address.builder()
                        .city("Pretoria")
                        .code(0435)
                        .country("RSA")
                        .houseNumber("20")
                        .province("Gauteng")
                        .streetName("Coatbridge")
                        .build())
                .build();
        try {
            clientService.createClient(client);
        } catch (ClientException ce) {
            ce.printStackTrace();
        }
    }

    @Test
    public void testSuccessClientUpdateService() {
        Client client = clientService.searchClientByFirstName("Tumisang");
        client.setFirstName("Hecious");
        clientService.updateClient(client);
    }

    @Test
    public void testSuccessSearchClientByFirstName() {
        Client client = clientService.searchClientByFirstName("Tumisang");
        assertThat(client).isNotNull();
    }

    @Test
    public void testSuccessSearchClientByIdNumber() {
        Client client = clientService.searchClientByIdNumber("9301205582086");
        assertThat(client).isNotNull();
    }

    @Test
    public void testSuccessSearchClientByMobileNumber() {
        Client client = clientService.searchClientByMobileNumber("0123456789");
        assertThat(client).isNotNull();
    }

    @Test
    public void test() {
        String idNumber = "9301205582086";
        System.out.println(idNumber.charAt(10));
    }

}
