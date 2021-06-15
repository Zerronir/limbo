package com.limbo.DAO;

import com.limbo.entities.Targeta;
import com.limbo.service.ClientService;
import com.limbo.service.ClientServiceAccess;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TargetAccess implements TargetaDAO{
    @Override
    public ArrayList<Targeta> findAllByUserIdEquals(int user_id) throws Exception {
        ArrayList<Targeta> targetes = new ArrayList<>();
        Connection conn = Database.getConnection();

        ClientService c = new ClientServiceAccess();
        c.getClientByNumero_Client(user_id); // Retorna una excepció si no troba l'usuari

        PreparedStatement ps = conn.prepareStatement("SELECT * FROM targeta WHERE client_id = ?");
        ps.setInt(1, user_id);

        ResultSet rs = ps.executeQuery();

        if(rs.next()) {

            Targeta t = new Targeta();

            t.setId(rs.getInt("id"));
            t.setTipus(rs.getString("tipus"));
            t.setNumero(rs.getLong("numero"));
            t.setData_caducitat(rs.getDate("data_caducitat"));
            t.setCodi_seguretat(rs.getInt("codi_seguretat"));

            targetes.add(t);

        } else {

            rs.close();
            ps.close();
            Database.closeConnection();
            throw new Exception("El client no té cap targeta asignada, per favor registra una");
        }

        rs.close();
        ps.close();
        Database.closeConnection();

        return targetes;
    }

    @Override
    public Targeta save(Targeta targeta) throws Exception {
        return null;
    }

    @Override
    public Targeta delete(Targeta targeta) throws Exception {
        return null;
    }
}
