package com.limbo.service;

import com.limbo.DAO.CiutatAccess;
import com.limbo.DAO.CiutatDAO;
import com.limbo.entities.Ciutat;

import java.util.ArrayList;

public class CiutatServiceAccess implements CiutatService{
    @Override
    public ArrayList<Ciutat> getAll() throws Exception {
        CiutatDAO cd = new CiutatAccess();
        return cd.getAll();
    }

    @Override
    public Ciutat getCiutatByNomEquals(String nom) throws Exception {
        CiutatDAO cd = new CiutatAccess();
        return cd.getCiutatByNomEquals(nom);
    }
}
