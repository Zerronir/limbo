package com.limbo.service;

import com.limbo.entities.Client;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public interface ClientService {
    String hashPassword(String pass) throws NoSuchAlgorithmException;
    Client findByUsernameEqualsAndPasswordEquals(String username, String password) throws Exception;
    Client save(Client client) throws Exception;
    Client update(Client client) throws SQLException, Exception;
    boolean delete(Client client) throws Exception;
    Client getClientByNumero_Client(int numero_client) throws Exception;
}
