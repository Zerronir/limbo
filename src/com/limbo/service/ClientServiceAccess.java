package com.limbo.service;

import com.limbo.DAO.ClientAccess;
import com.limbo.DAO.ClientDAO;
import com.limbo.entities.Client;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class ClientServiceAccess implements ClientService{
    @Override
    public String hashPassword(String pass) throws NoSuchAlgorithmException {
        ClientDAO cd = new ClientAccess();
        return cd.hashPassword(pass);
    }

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

    @Override
    public Client update(Client client) throws SQLException, Exception {
        ClientDAO cd = new ClientAccess();
        return cd.update(client);
    }

    @Override
    public boolean delete(Client client) throws Exception {
        ClientDAO cd = new ClientAccess();
        return cd.delete(client);
    }

    @Override
    public Client getClientByNumero_Client(int numero_client) throws Exception {
        ClientDAO cd = new ClientAccess();
        return cd.getClientByNumero_Client(numero_client);
    }
}
