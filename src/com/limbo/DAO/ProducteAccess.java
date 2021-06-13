package com.limbo.DAO;

import com.limbo.entities.Producte;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

public class ProducteAccess implements ProducteDAO{

    @Override
    public Vector<Producte> taulellProductes() throws Exception {
        Vector<Producte> productes = new Vector<Producte>();

        Connection conn = Database.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM producte p LEFT JOIN categoria c ON p.categoria = c.id");

        ResultSet rs = ps.executeQuery();

        if(rs.next()) {
            while (rs.next()) {
                Producte p = new Producte();
                p.setId(rs.getInt("p.id"));
                p.setNom(rs.getString("p.nom"));
                p.setDescripcio(rs.getString("p.descripcio"));
                p.setPvp(rs.getDouble("p.pvp"));
                p.setIva(rs.getInt("p.iva"));
                p.setMarca(rs.getString("p.marca"));
                p.setUnitat_mesura(rs.getString("p.unitat_mesura"));
                p.setPes(rs.getDouble("p.pes"));
                p.setCategoria(rs.getString("c.nom"));

                productes.add(p);
            }
            return productes;
        } else {
            Producte p = new Producte();
            productes.add(p);
            return productes;
        }
    }

    @Override
    public Producte findByIdEquals(int numero_producte) throws Exception {
        Connection conn = Database.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM producte p LEFT JOIN categoria c ON p.categoria = c.id WHERE p.id = ?");
        ps.setInt(1, numero_producte);
        ResultSet rs = ps.executeQuery();

        if(rs.next()) {
            Producte p = new Producte();

            p.setId(rs.getInt("p.id"));
            p.setNom(rs.getString("p.nom"));
            p.setPvp(rs.getDouble("p.pvp"));
            p.setIva(rs.getInt("p.iva"));
            p.setMarca(rs.getString("p.marca"));
            p.setUnitat_mesura(rs.getString("p.unitat_mesura"));
            p.setPes(rs.getDouble("p.pes"));
            p.setCategoria(rs.getString("c.nom"));

            ps.close();
            rs.close();
            Database.closeConnection();
            return p;

        } else {
            ps.close();
            rs.close();
            Database.closeConnection();
            throw new Exception("No existeix cap producte amb aquest número");
        }

    }
}
