package br.com.fatec.web.dao;

import br.com.fatec.web.domain.Category;
import br.com.fatec.web.domain.IDominio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao implements IDAO {
    private Category category;
    private List<IDominio> categoryList;
    private String sql;

    @Override
    public boolean save(IDominio domain) {
        category = (Category) domain;
        if (category.getId() > 0)
            sql = "UPDATE \"category\" SET name=?, observation=? WHERE id=" + category.getId();
        else
            sql = "INSERT INTO \"category\" (name, observation) VALUES (?,?)";

        Connection conn = null;

        try {
            conn = Connect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, category.getName());
            ps.setString(2, category.getObservation());
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
        category = (Category) domain;
        Connection conn = null;

        sql = "DELETE FROM \"category\" WHERE id=?";
        try {
            conn = Connect.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, category.getId());
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
        category = (Category) domain;
        Connection conn = null;

        sql = "SELECT * FROM \"category\" WHERE id=" + category.getId();

        try {
            conn = Connect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setObservation(rs.getString("observation"));

                return category;
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
        Connection conn = null;

        sql = "SELECT * FROM \"category\"";

        try {
            conn = Connect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            categoryList = new ArrayList<IDominio>();
            while (rs.next()) {
                category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setObservation(rs.getString("observation"));

                categoryList.add(category);
            }

            return categoryList;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            Connect.close(conn);
        }
        return null;
    }
}
