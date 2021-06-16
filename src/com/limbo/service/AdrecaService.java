package com.limbo.service;

import com.limbo.entities.Adreca;

import java.util.ArrayList;

public interface AdrecaService {
    ArrayList<Adreca> findAllByUserIdEquals(int user_id) throws Exception;
    Adreca save(Adreca adreca) throws Exception;
    Adreca getAdrecaByCarrerEquals(String carrer) throws Exception;
}
