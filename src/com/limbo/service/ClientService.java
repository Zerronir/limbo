package com.limbo.service;

import com.limbo.entities.Client;

public interface ClientService {
    Client findByUsernameEqualsAndPasswordEquals(String username, String password) throws Exception;
}
