package com.limbo.DAO;

import com.limbo.entities.Producte;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

public interface ProducteDAO {
    Vector<Producte> taulellProductes() throws Exception;
    Producte findByIdEquals(int numero_producte) throws Exception;
}
