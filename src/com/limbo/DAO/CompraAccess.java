package com.limbo.DAO;

import com.limbo.entities.Compra;
import com.limbo.entities.DetallCompra;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CompraAccess implements CompraDAO {
    @Override
    public Compra save(Compra compra) throws Exception {

        Compra c = compra;
        Connection conn = Database.getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO compra (targeta_id, adreca_id, client_id, id_transaccio, data) VALUES (?, ?, ?, ?, ?)");
        ps.setInt(1, c.getTargeta_id());
        ps.setInt(2, c.getAdreca_id());
        ps.setInt(3, c.getClient_id());
        ps.setString(4, c.getId_transaccio());
        ps.setDate(5, c.getData());
        boolean store = ps.execute();

        ps = conn.prepareStatement("SELECT max(id) as idCompra FROM compra");
        ResultSet rs = ps.executeQuery();
        int id = rs.next() ? id = rs.getInt("idCompra") : 1;


        if (store == false) {
            c.setId(id);
            ps.close();
            rs.close();
            Database.closeConnection();
            return c;
        } else {
            throw new Exception("La compra no s'ha pogut processar");
        }
    }

    @Override
    public DetallCompra saveDetall(DetallCompra detallCompra) throws Exception {
        DetallCompra dc = detallCompra;
        Connection conn = Database.getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO detall_compra (compra_id, producte_id, pvp, pes, unitats_producte) VALUES (?, ?, ?, ?, ?)");

        ps.setInt(1, dc.getCompra_id());
        ps.setInt(2, dc.getProducte_id());
        ps.setDouble(3, dc.getPvp());
        ps.setDouble(4, dc.getPes());
        ps.setInt(5, dc.getUnitats_producte());

        if(!ps.execute()) {
            ps.close();
            Database.closeConnection();
        } else {
            throw new Exception("No s'ha pogut emmagatzemar el detall de la compra");
        }

        return dc;
    }
}
