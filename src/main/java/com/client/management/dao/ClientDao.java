package com.client.management.dao;

import com.client.management.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientDao extends JpaRepository<Client, Long> {

    Client findByFirstName(String firstName);

    Client findByIdNumber(String idNumber);

    Client findByMobileNumber(String mobileNumber);
}
