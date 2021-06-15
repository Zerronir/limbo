package com.limbo.DAO;

import com.limbo.entities.Targeta;

import java.util.ArrayList;

public interface TargetaDAO {
    ArrayList<Targeta> findAllByUserIdEquals(int user_id) throws Exception;
    Targeta save(Targeta targeta) throws Exception;
    Targeta delete(Targeta targeta) throws Exception;
}
