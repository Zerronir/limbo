package com.limbo.DAO;

import com.limbo.entities.Client;
import com.limbo.service.ClientService;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public interface ClientDAO {
    String hashPassword(String pass) throws NoSuchAlgorithmException;
    Client findByUsernameEqualsAndPasswordEquals(String username, String password) throws Exception;
    Client save(Client client) throws SQLException, Exception;
    Client update(Client client) throws SQLException, Exception;
    boolean delete(Client client) throws Exception;
    Client getClientByNumero_Client(int numero_client) throws Exception;
}
