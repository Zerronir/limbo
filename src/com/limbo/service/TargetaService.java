package com.limbo.service;

import com.limbo.entities.Targeta;

import java.util.ArrayList;

public interface TargetaService {
    ArrayList<Targeta> findAllByUserIdEquals(int user_id) throws Exception;
    Targeta save(Targeta targeta) throws Exception;
    Targeta delete(Targeta targeta) throws Exception;
}
