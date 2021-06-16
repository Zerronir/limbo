package com.limbo.service;

import com.limbo.DAO.TargetAccess;
import com.limbo.DAO.TargetaDAO;
import com.limbo.entities.Targeta;

import java.util.ArrayList;

public class TargetaServiceAccess implements TargetaService{

    @Override
    public ArrayList<Targeta> findAllByUserIdEquals(int user_id) throws Exception {
        TargetaDAO td = new TargetAccess();
        return td.findAllByUserIdEquals(user_id);
    }

    @Override
    public Targeta save(Targeta targeta) throws Exception {
        TargetaDAO td = new TargetAccess();
        return td.save(targeta);
    }

    @Override
    public Targeta delete(Targeta targeta) throws Exception {
        TargetaDAO td = new TargetAccess();
        return td.delete(targeta);
    }

    @Override
    public Targeta getByNumeroEquals(String num) throws Exception {
        TargetaDAO td = new TargetAccess();
        return td.getByNumeroEquals(num);
    }
}
