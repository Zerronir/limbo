package com.limbo.DAO;

import com.limbo.entities.Adreca;
import com.limbo.entities.Targeta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AdrecaAccess implements AdrecaDAO{
    @Override
    public ArrayList<Adreca> findAllByUserIdEquals(int user_id) throws Exception {
        ArrayList<Adreca> adrecas = new ArrayList<>();
        Connection conn = Database.getConnection();

        PreparedStatement ps = conn.prepareStatement("SELECT * FROM adreca WHERE client_id = ?");
        ps.setInt(1, user_id);

        ResultSet rs = ps.executeQuery();

        try {
            while(rs.next()) {
                Adreca a = new Adreca();

                a.setId(rs.getInt("id"));
                a.setClient_id(rs.getInt("client_id"));
                a.setNumero(rs.getString("numero"));
                a.setCarrer(rs.getString("carrer"));
                a.setPis(rs.getInt("pis"));
                a.setPorta(rs.getString("porta"));
                a.setCp(rs.getString("CP"));

                adrecas.add(a);
            }

            rs.close();
            ps.close();
            Database.closeConnection();
            return adrecas;
        } catch (Exception e) {
            throw new Exception("El client no té cap adreça, per favor registra una");
        }
    }

    @Override
    public Adreca save(Adreca adreca) throws Exception {
        Adreca a = adreca;
        Connection conn = Database.getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO adreca (client_id, carrer, numero, pis, porta, CP, ciutat_id) VALUES (?, ?, ?, ?, ?, ?, ?)");
        ps.setInt(1, a.getClient_id());
        ps.setString(2, a.getCarrer());
        ps.setString(3, a.getNumero());
        ps.setInt(4, a.getPis());
        ps.setString(5, a.getPorta());
        ps.setString(6, a.getCp());
        ps.setInt(7, a.getCiutat_id());

        if(ps.execute() == true) {
            ps.close();
            Database.closeConnection();
            return a;
        } else {
            throw new Exception("No s'ha pogut crear la adreça");
        }
    }

    @Override
    public Adreca getAdrecaByCarrerEquals(String carrer) throws Exception {
        Adreca a = new Adreca();
        Connection conn = Database.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM adreca WHERE carrer = ?");
        ps.setString(1, carrer);
        ResultSet rs = ps.executeQuery();

        if(rs.next()) {

            a.setId(rs.getInt("id"));

            rs.close();
            ps.close();
            Database.closeConnection();
        } else {
            throw new Exception("La adreça no existeix");
        }

        return a;
    }
}
