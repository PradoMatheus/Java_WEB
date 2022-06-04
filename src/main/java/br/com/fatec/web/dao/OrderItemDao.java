package br.com.fatec.web.dao;

import br.com.fatec.web.domain.IDominio;
import br.com.fatec.web.domain.Order;
import br.com.fatec.web.domain.Order_Item;
import br.com.fatec.web.domain.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderItemDao implements IDAO {
    private Connection conn;
    private String sql;
    private Order order;
    private List<IDominio> orderItemsList;

    @Override
    public boolean save(IDominio domain) {
        order = (Order) domain;

        for (Order_Item item : order.getOrder_items()) {

            if (order.getId() > 0)
                sql = "UPDATE \"order_item\" SET quantity=?, value=?, product_id=?, order_id=? WHERE order_id =" + order.getId();
            else
                sql = "INSERT INTO \"order_item\" (quantity, value, product_id, order_id) VALUES (?, ?, ?, ?);";
            conn = null;

            try {
                conn = Connect.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, item.getQuantity());
                ps.setDouble(2, item.getValue());
                ps.setInt(3, item.getProduct().getId());
                ps.setInt(4, order.getId());
                ps.execute();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean delete(IDominio domain) {
        return false;
    }

    @Override
    public IDominio search(IDominio domain) {
        return null;
    }

    @Override
    public List<IDominio> list(IDominio domain) {
        order = (Order) domain;
        conn = null;

        sql = "SELECT * FROM \"order_item\" WHERE order_id = " + order.getId();

        try {
            conn = Connect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            orderItemsList = new ArrayList<IDominio>();
            while (rs.next()) {
                Order_Item item = new Order_Item();
                item.setId(rs.getInt("id"));
                item.setQuantity(rs.getInt("quantity"));
                item.setValue(rs.getDouble("value"));
                Product product = new Product();
                product.setId(rs.getInt("product_id"));
                item.setProduct((Product) new ProductDao().search(product));

                orderItemsList.add(item);
            }
            return orderItemsList;

        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            Connect.close(conn);
        }

        return null;
    }
}
