package br.com.fatec.web.dao;

import br.com.fatec.web.domain.Client;
import br.com.fatec.web.domain.IDominio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClientDao implements IDAO {
    private Connection conn;
    private String sql;
    private Client client;
    private List<IDominio> clientList;

    @Override
    public boolean save(IDominio domain) {
        client = (Client) domain;
        if (client.getId() > 0)
            sql = "UPDATE \"client\" SET active=?, address=?, cellphone=?, city=?, cpf=?, district=?, email=?, name=?, number_house=?, zip=? WHERE id=" + client.getId();
        else
            sql = "INSERT INTO \"client\" (active, address, cellphone, city, cpf, district, email, name, number_house, zip) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        conn = null;
        try {
            conn = Connect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setBoolean(1, client.isActive());
            ps.setString(2, client.getAddress());
            ps.setLong(3, client.getCellphone());
            ps.setString(4, client.getCity());
            ps.setLong(5, client.getCpf());
            ps.setString(6, client.getDistrict());
            ps.setString(7, client.getEmail());
            ps.setString(8, client.getName());
            ps.setInt(9, client.getNumber_house());
            ps.setInt(10, client.getZip());
            ps.execute();

            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(IDominio domain) {
        client = (Client) domain;
        conn = null;

        sql = "DELETE FROM \"client\" WHERE id=?";
        try {
            conn = Connect.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, client.getId());
            pstm.execute();

            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            Connect.close(conn);
        }

        return false;
    }

    @Override
    public IDominio search(IDominio domain) {
        client = (Client) domain;
        conn = null;

        sql = "SELECT * FROM \"client\" WHERE id=" + client.getId();

        try {
            conn = Connect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                client = new Client();
                client.setId(rs.getInt("id"));
                client.setActive(rs.getBoolean("active"));
                client.setAddress(rs.getString("address"));
                client.setCellphone(rs.getLong("cellphone"));
                client.setCity(rs.getString("city"));
                client.setCpf(rs.getLong("cpf"));
                client.setDistrict(rs.getString("district"));
                client.setEmail(rs.getString("email"));
                client.setNumber_house(rs.getInt("number_house"));
                client.setName(rs.getString("name"));
                client.setZip(rs.getInt("zip"));

                return client;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            Connect.close(conn);
        }

        return null;
    }

    @Override
    public List<IDominio> list(IDominio domain) {
        client = (Client) domain;
        conn = null;

        sql = "SELECT * FROM \"client\"";

        try {
            conn = Connect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            clientList = new ArrayList<IDominio>();
            while (rs.next()) {
                client = new Client();
                client.setId(rs.getInt("id"));
                client.setActive(rs.getBoolean("active"));
                client.setAddress(rs.getString("address"));
                client.setCellphone(rs.getLong("cellphone"));
                client.setCity(rs.getString("city"));
                client.setCpf(rs.getLong("cpf"));
                client.setDistrict(rs.getString("district"));
                client.setEmail(rs.getString("email"));
                client.setNumber_house(rs.getInt("number_house"));
                client.setName(rs.getString("name"));
                client.setZip(rs.getInt("zip"));

                clientList.add(client);
            }
            return clientList;

        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            Connect.close(conn);
        }

        return null;
    }
}
