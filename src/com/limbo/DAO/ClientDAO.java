package com.limbo.DAO;

import com.limbo.entities.Client;
import com.limbo.service.ClientService;

public interface ClientDAO {
    public Client findByUsernameEqualsAndPasswordEquals(String username, String password) throws Exception;
}
