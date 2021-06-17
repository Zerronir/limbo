package com.limbo.DAO;

import com.limbo.entities.Targeta;
import com.limbo.service.ClientService;
import com.limbo.service.ClientServiceAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TargetAccess implements TargetaDAO{
    @Override
    public ArrayList<Targeta> findAllByUserIdEquals(int user_id) throws Exception {
        ArrayList<Targeta> targetes = new ArrayList<>();
        Connection conn = Database.getConnection();

        PreparedStatement ps = conn.prepareStatement("SELECT * FROM targeta WHERE client_id = ?");
        ps.setInt(1, user_id);

        ResultSet rs = ps.executeQuery();

        try {
            while(rs.next()) {
                Targeta t = new Targeta();

                t.setId(rs.getInt("id"));
                t.setTipus(rs.getString("tipus"));
                t.setNumero(rs.getLong("numero"));
                t.setData_caducitat(rs.getDate("data_caducitat"));
                t.setCodi_seguretat(rs.getInt("codi_seguretat"));
                t.setClient_id(rs.getInt("client_id"));

                targetes.add(t);
            }

            rs.close();
            ps.close();
            Database.closeConnection();
            return targetes;
        } catch (Exception e) {
            throw new Exception("El client no té cap targeta asignada, per favor registra una");
        }

    }

    @Override
    public Targeta save(Targeta targeta) throws Exception {
        try {
            Targeta t = targeta;

            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO targeta (tipus, numero, data_caducitat, codi_seguretat, client_id) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, t.getTipus());
            ps.setLong(2, t.getNumero());
            ps.setDate(3, t.getData_caducitat());
            ps.setInt(4, t.getCodi_seguretat());
            ps.setInt(5, t.getClient_id());

            if(!ps.execute()) {
                ps.close();
                conn.close();
                Database.closeConnection();
                return t;
            } else {
                throw new Exception("La targeta no s'ha pogut guardar per un error a la base de dades, per favor torna-ho a probar");
            }
        }catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Targeta delete(Targeta targeta) throws Exception {
        return null;
    }

    @Override
    public Targeta getByNumeroEquals(String num) throws Exception {
        Targeta t = new Targeta();
        Long numero = Long.parseLong(num);
        Connection conn = Database.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM targeta WHERE numero = ?");
        ps.setLong(1, numero);
        ResultSet rs = ps.executeQuery();

        if(rs.next()) {

            t.setId(rs.getInt("id"));

            rs.close();
            ps.close();
            Database.closeConnection();
        } else {
            throw new Exception("La targeta no existeix");
        }

        return t;
    }
}
