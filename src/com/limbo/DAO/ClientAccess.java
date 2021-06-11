package com.limbo.DAO;

import com.limbo.entities.Client;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClientAccess implements ClientDAO {
    @Override
    public Client findByUsernameEqualsAndPasswordEquals(String username, String password) throws Exception {
        Client c = new Client();

        if(!username.equals("") && !password.equals("")) {
            Connection conn = Database.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM client WHERE username LIKE ? AND contrasenya LIKE ?");
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                c.setNumero_client(rs.getInt("numero_client"));
                c.setEmail(rs.getString("email"));
                c.setNom(rs.getString("nom"));
                c.setCognom1(rs.getString("cognom1"));
                c.setCognom2(rs.getString("cognom2"));
                c.setUsername(rs.getString("username"));
                c.setContrasenya("");
            } else {
                throw new Exception("L'usuari no existeix amb les dades que has introduït, per favor revisales");
            }

            ps.close();
            Database.closeConnection();

            if(c.getNumero_client() < 1) {
                throw new Exception("L'usuari no s'ha trobat a la base de dades");
            }

        } else if(username.equals("") || password.equals("")) {
            throw new Exception("El camp de nom d'usuari està o de la contrasenya buit");
        }

        return c;
    }
}
