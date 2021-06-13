package com.limbo.DAO;

import com.limbo.entities.Client;
import com.limbo.service.ClientService;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public interface ClientDAO {
    String hashPassword(String pass) throws NoSuchAlgorithmException;
    Client findByUsernameEqualsAndPasswordEquals(String username, String password) throws Exception;
    Client save(Client client) throws SQLException, Exception;
}
