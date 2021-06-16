package com.limbo.DAO;

import com.limbo.entities.Ciutat;

import java.util.ArrayList;

public interface CiutatDAO {
    ArrayList<Ciutat> getAll() throws Exception;
    Ciutat getCiutatByNomEquals(String nom) throws Exception;
}
