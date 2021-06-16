package com.limbo.DAO;

import com.limbo.entities.Adreca;
import com.limbo.entities.Targeta;

import java.util.ArrayList;

public interface AdrecaDAO {
    ArrayList<Adreca> findAllByUserIdEquals(int user_id) throws Exception;
    Adreca save(Adreca adreca) throws Exception;
    Adreca getAdrecaByCarrerEquals(String carrer) throws Exception;
}
