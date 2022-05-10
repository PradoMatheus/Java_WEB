package br.com.fatec.web.dao;

import br.com.fatec.web.domain.Category;
import br.com.fatec.web.domain.IDominio;
import br.com.fatec.web.domain.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements IDAO {

    private String sql;
    private Product product;
    private List<IDominio> productList;

    @Override
    public boolean save(IDominio domain) {
        product = (Product) domain;

        if (product.getId() > 0)
            sql = "UPDATE \"product\" SET active=?, description=?, ean=?, name=?, value=?, category_id=? WHERE id=" + product.getId();
        else
            sql = "INSERT INTO \"product\" (active, description, ean, name, value, category_id) VALUES (?, ?, ?, ?, ?, ?)";

        Connection conn = null;

        try {
            conn = Connect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setBoolean(1, product.isActive());
            ps.setString(2, product.getDescription());
            ps.setString(3, product.getEan());
            ps.setString(4, product.getName());
            ps.setDouble(5, product.getValue());
            ps.setInt(6, product.getCategory().getId());
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
        product = (Product) domain;
        Connection conn = null;

        sql = "DELETE FROM \"product\" WHERE id=?";
        try {
            conn = Connect.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, product.getId());
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
        product = (Product) domain;
        Connection conn = null;

        sql = "SELECT * FROM \"product\" WHERE id=" + product.getId();

        try {
            conn = Connect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                product = new Product();
                product.setId(rs.getInt("id"));
                product.setActive(rs.getBoolean("active"));
                product.setDescription(rs.getString("description"));
                product.setEan(rs.getString("ean"));
                product.setName(rs.getString("name"));
                product.setValue(rs.getDouble("value"));

                Category category = new Category();
                category.setId(rs.getInt("category_id"));
                product.setCategory((Category) new CategoryDao().search(category));

                return product;
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

        sql = "SELECT * FROM \"product\"";

        productList = new ArrayList<IDominio>();

        try {
            conn = Connect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                product = new Product();
                product.setId(rs.getInt("id"));
                product.setActive(rs.getBoolean("active"));
                product.setDescription(rs.getString("description"));
                product.setEan(rs.getString("ean"));
                product.setName(rs.getString("name"));
                product.setValue(rs.getDouble("value"));

                Category category = new Category();
                category.setId(rs.getInt("category_id"));
                product.setCategory((Category) new CategoryDao().search(category));
                productList.add(product);
            }
            return productList;

        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            Connect.close(conn);
        }

        return null;
    }
}
