package br.com.fatec.web.dao;

import br.com.fatec.web.domain.IDominio;
import br.com.fatec.web.domain.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoleDao implements IDAO {
    private Role role;
    private List<IDominio> roleList;
    private String sql;

    @Override
    public boolean save(IDominio domain) {
        role = (Role) domain;
        if (role.getId() > 0)
            sql = "UPDATE \"role\" SET active=?, name=?, observation=? WHERE id=" + role.getId();
        else
            sql = "INSERT INTO \"role\" (active, name, observation) VALUES (?,?,?)";

        Connection conn = null;

        try {
            conn = Connect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setBoolean(1, role.isActive());
            ps.setString(2, role.getName());
            ps.setString(3, role.getObservation());
            ps.execute();

            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            Connect.close(conn);
        }
        return false;
    }

    @Override
    public boolean delete(IDominio domain) {
        role = (Role) domain;
        Connection conn = null;

        sql = "DELETE FROM \"role\" WHERE id=?";
        try {
            conn = Connect.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, role.getId());
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
        role = (Role) domain;
        Connection conn = null;

        sql = "SELECT * FROM \"role\" WHERE id=" + role.getId();

        try {
            conn = Connect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                role = new Role();
                role.setId(rs.getInt("id"));
                role.setActive(rs.getBoolean("active"));
                role.setName(rs.getString("name"));
                role.setObservation(rs.getString("observation"));
                return role;
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
        role = (Role) domain;
        roleList = new ArrayList<IDominio>();
        Connection conn = null;

        sql = "SELECT * FROM \"role\"";

        try {
            conn = Connect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                role = new Role();
                role.setId(rs.getInt("id"));
                role.setActive(rs.getBoolean("active"));
                role.setName(rs.getString("name"));
                role.setObservation(rs.getString("observation"));
                roleList.add(role);
            }
            return roleList;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            Connect.close(conn);
        }
        return null;
    }
}
