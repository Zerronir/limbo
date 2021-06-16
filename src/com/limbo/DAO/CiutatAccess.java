package com.limbo.DAO;

import com.limbo.entities.Ciutat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CiutatAccess implements CiutatDAO{
    @Override
    public ArrayList<Ciutat> getAll() throws Exception {
        ArrayList<Ciutat> arrayList = new ArrayList<>();
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM ciutat");
        ResultSet rs = ps.executeQuery();

        if(rs.next()) {
            while (rs.next()) {
                Ciutat c = new Ciutat();
                c.setId(rs.getInt("id"));
                c.setNom(rs.getString("nom"));
                c.setProvincia_id(rs.getInt("provincia_id"));

                arrayList.add(c);
            }
        } else {
            throw new Exception("No s'ha pogut crear la llista de ciutats");
        }

        ps.close();
        rs.close();
        Database.closeConnection();
        return arrayList;
    }

    @Override
    public Ciutat getCiutatByNomEquals(String nom) throws Exception {
        Ciutat c = new Ciutat();
        Connection conn = Database.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM ciutat WHERE nom LIKE ?");
        ps.setString(1, nom);
        ResultSet rs = ps.executeQuery();

        if(rs.next()) {
            c.setId(rs.getInt("id"));
            c.setNom(rs.getString("nom"));
            c.setProvincia_id(rs.getInt("provincia_id"));
        } else {
            throw new Exception("La ciutat: " + nom + " no s'ha trobat a la base de dades");
        }

        ps.close();
        rs.close();
        Database.closeConnection();
        return c;
    }
}
