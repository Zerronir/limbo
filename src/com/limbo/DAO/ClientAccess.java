package com.limbo.DAO;

import com.limbo.entities.Client;

import javax.xml.crypto.Data;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientAccess implements ClientDAO {
    @Override
    public String hashPassword(String pass) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(pass.getBytes());
        byte[] dg = md.digest();
        StringBuilder hexString = new StringBuilder();
        for(byte b : dg) {
            hexString.append(Integer.toHexString(0xFF & b));
        }
        return hexString.toString();
    }

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
            rs.close();
            Database.closeConnection();

            if(c.getNumero_client() < 1) {
                throw new Exception("L'usuari no s'ha trobat a la base de dades");
            }

        } else if(username.equals("") || password.equals("")) {
            throw new Exception("El camp de nom d'usuari està o de la contrasenya buit");
        }

        return c;
    }

    @Override
    public Client save(Client client) throws Exception {
        Client c = new Client();
        c.setNumero_client(1);
        c.setNom(client.getNom());
        c.setCognom1(client.getCognom1());
        c.setCognom2(client.getCognom2());
        c.setEmail(client.getEmail());
        c.setUsername(client.getUsername());
        c.setContrasenya(client.getContrasenya());

        Connection conn = Database.getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO " +
                "client (email, nom, cognom1, cognom2, username, contrasenya)" +
                " VALUES (?, ?, ?, ?, ?, ?)");

        ps.setString(1, c.getEmail());
        ps.setString(2, c.getNom());
        ps.setString(3, c.getCognom1());
        ps.setString(4, c.getCognom2());
        ps.setString(5, c.getUsername());
        ps.setString(6, c.getContrasenya());

        ps.execute();
        if(ps.execute()) {
            ps.close();
            Database.closeConnection();
            return c;
        } else {
            throw new Exception("L'usuari no s'ha pogut registrar, torna-ho a provar per favor");
        }
    }

    @Override
    public Client update(Client client) throws SQLException, Exception {
        Client c = client;

        Connection conn = Database.getConnection();
        PreparedStatement ps = conn.prepareStatement("");

        if(!c.getContrasenya().equals("")) {
            ps = conn.prepareStatement("UPDATE client SET email = ?, nom = ?, cognom1 = ?, cognom2 = ?, username = ?, contrasenya = ? WHERE numero_client = ?");
            ps.setString(1, c.getEmail());
            ps.setString(2, c.getNom());
            ps.setString(3, c.getCognom1());
            ps.setString(4, c.getCognom2());
            ps.setString(5, c.getUsername());
            ps.setString(6, c.getContrasenya());
            ps.setInt(7, c.getNumero_client());
        } else {
            ps = conn.prepareStatement("UPDATE client SET email = ?, nom = ?, cognom1 = ?, cognom2 = ?, username = ? WHERE numero_client = ?");
            ps.setString(1, c.getEmail());
            ps.setString(2, c.getNom());
            ps.setString(3, c.getCognom1());
            ps.setString(4, c.getCognom2());
            ps.setString(5, c.getUsername());
            ps.setInt(6, c.getNumero_client());
        }

        if(ps.execute()) {
            ps.close();
            Database.closeConnection();
            return c;
        } else {
            throw new Exception("L'usuari no ha pogut ser actualitzat");
        }
    }

    @Override
    public boolean delete(Client client) throws Exception {
        Connection conn = Database.getConnection();
        PreparedStatement ps = conn.prepareStatement("DELETE * FROM client WHERE numero_client = ?");
        ps.setInt(1, client.getNumero_client());

        if(ps.execute()) {
            ps.close();
            Database.closeConnection();
            return true;
        } else {
            throw new Exception("No s'ha pogut eliminar el contacte");
        }
    }

    @Override
    public Client getClientByNumero_Client(int numero_client) throws Exception {
        Connection conn = Database.getConnection();
        Client c = new Client();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM client WHERE numero_client = ?");
        ps.setInt(1, numero_client);

        ResultSet rs = ps.executeQuery();

        if(rs.next()) {
            c.setNom(rs.getString("nom"));
            c.setCognom1(rs.getString("cognom1"));
            c.setCognom2(rs.getString("cognom2"));
            c.setEmail(rs.getString("email"));
            c.setUsername(rs.getString("username"));

            ps.close();
            rs.close();
            Database.closeConnection();

            // Retornam el client
            return c;
        } else {
            throw new Exception("L'usuari no existeix amb el número de client introduit");
        }

    }
}
