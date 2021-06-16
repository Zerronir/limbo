package com.limbo.service;

import com.limbo.entities.Ciutat;

import java.util.ArrayList;

public interface CiutatService {
    ArrayList<Ciutat> getAll() throws Exception;
    Ciutat getCiutatByNomEquals(String nom) throws Exception;
}
