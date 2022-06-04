package br.com.fatec.web.dao;

import br.com.fatec.web.domain.Collaborator;
import br.com.fatec.web.domain.IDominio;
import br.com.fatec.web.domain.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CollaboratorDao implements IDAO {
    private Collaborator collaborator;
    private List<IDominio> collaboratorList;
    private String sql;
    private Connection conn;

    @Override
    public boolean save(IDominio domain) {
        collaborator = (Collaborator) domain;
        if (collaborator.getId() > 0)
            sql = "UPDATE \"collaborator\" SET active=?, email=?, name=?, observation=?, role_id=? WHERE id=" + collaborator.getId();
        else
            sql = "INSERT INTO \"collaborator\" (active, email, name, observation, role_id) VALUES (?, ?, ?, ?, ?);";

        conn = null;

        try {
            conn = Connect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setBoolean(1, collaborator.isActive());
            ps.setString(2, collaborator.getEmail());
            ps.setString(3, collaborator.getName());
            ps.setString(4, collaborator.getObservation());
            ps.setInt(5, collaborator.getRole().getId());
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
        collaborator = (Collaborator) domain;
        Connection conn = null;

        sql = "DELETE FROM \"collaborator\" WHERE id=?";
        try {
            conn = Connect.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, collaborator.getId());
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
        collaborator = (Collaborator) domain;
        conn = null;

        sql = "SELECT * FROM \"collaborator\" WHERE id=" + collaborator.getId();

        try {
            conn = Connect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                collaborator = new Collaborator();
                collaborator.setId(rs.getInt("id"));
                collaborator.setActive(rs.getBoolean("active"));
                collaborator.setObservation(rs.getString("observation"));
                collaborator.setEmail(rs.getString("email"));
                collaborator.setName(rs.getString("name"));
                Role role = new Role();
                role.setId(rs.getInt("role_id"));
                collaborator.setRole((Role) new RoleDao().search(role));

                return collaborator;
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
        collaborator = (Collaborator) domain;
        conn = null;

        sql = "SELECT * FROM \"collaborator\"";

        try {
            conn = Connect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            collaboratorList = new ArrayList<IDominio>();
            while (rs.next()) {
                collaborator = new Collaborator();
                collaborator.setId(rs.getInt("id"));
                collaborator.setActive(rs.getBoolean("active"));
                collaborator.setObservation(rs.getString("observation"));
                collaborator.setEmail(rs.getString("email"));
                collaborator.setName(rs.getString("name"));
                Role role = new Role();
                role.setId(rs.getInt("role_id"));
                collaborator.setRole((Role) new RoleDao().search(role));

                collaboratorList.add(collaborator);
            }
            return collaboratorList;

        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            Connect.close(conn);
        }

        return null;
    }
}
