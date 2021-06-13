package com.limbo.service;

import com.limbo.entities.Producte;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

public interface ProducteService {
    Vector<Producte> taulellProductes() throws Exception;
    Producte findByIdEquals(int numero_producte) throws Exception;
}
