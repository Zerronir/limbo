package com.limbo.service;

import com.limbo.DAO.AdrecaAccess;
import com.limbo.DAO.AdrecaDAO;
import com.limbo.entities.Adreca;

import java.util.ArrayList;

public class AdrecaServiceAccess implements AdrecaService {
    @Override
    public ArrayList<Adreca> findAllByUserIdEquals(int user_id) throws Exception {
        AdrecaDAO ad = new AdrecaAccess();
        return ad.findAllByUserIdEquals(user_id);
    }

    @Override
    public Adreca save(Adreca adreca) throws Exception {
        AdrecaDAO ad = new AdrecaAccess();
        return ad.save(adreca);
    }

    @Override
    public Adreca getAdrecaByCarrerEquals(String carrer) throws Exception {
        AdrecaDAO ad = new AdrecaAccess();
        return ad.getAdrecaByCarrerEquals(carrer);
    }
}
