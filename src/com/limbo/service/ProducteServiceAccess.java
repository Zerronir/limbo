package com.limbo.service;

import com.limbo.DAO.ProducteAccess;
import com.limbo.DAO.ProducteDAO;
import com.limbo.entities.Producte;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

public class ProducteServiceAccess implements ProducteService{

    @Override
    public Vector<Producte> taulellProductes() throws Exception {
        ProducteDAO pd = new ProducteAccess();
        return pd.taulellProductes();
    }

    @Override
    public Producte findByIdEquals(int numero_producte) throws Exception {
        ProducteDAO pd = new ProducteAccess();
        return pd.findByIdEquals(numero_producte);
    }
}
