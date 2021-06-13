package com.limbo.service;

import com.limbo.DAO.ClientAccess;
import com.limbo.DAO.ClientDAO;
import com.limbo.entities.Client;

public class ClientServiceAccess implements ClientService{
    @Override
    public Client findByUsernameEqualsAndPasswordEquals(String username, String password) throws Exception {
        ClientDAO cd = new ClientAccess();
        return cd.findByUsernameEqualsAndPasswordEquals(username, password);
    }

    @Override
    public Client save(Client client) throws Exception {
        ClientDAO cd = new ClientAccess();
        return cd.save(client) ;
    }
}
