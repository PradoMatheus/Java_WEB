package br.com.fatec.web.dao;

import br.com.fatec.web.domain.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderDao implements IDAO {
    private Connection conn;
    private String sql;
    private Order order;
    private List<IDominio> orderList;

    @Override
    public boolean save(IDominio domain) {
        order = (Order) domain;
        if (order.getId() > 0)
            sql = "UPDATE \"orders\" SET date_order=?, total_value=?, client_id=?, collaborator_id=?, payment_id=? WHERE id=" + order.getId();
        else
            sql = "INSERT INTO \"orders\" (date_order, total_value, client_id, collaborator_id, payment_id) VALUES (?, ?, ?, ?, ?) RETURNING id;";
        conn = null;
        try {
            conn = Connect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(order.getDate_order().toLocalDate()));
            ps.setDouble(2, order.getTotal_value());
            ps.setInt(3, order.getClient().getId());
            ps.setInt(4, order.getCollaborator().getId());
            ps.setLong(5, order.getPayment().getId());

            if (order.getId() > 0) {
                ps.execute();
            } else {
                ResultSet lastId = ps.executeQuery();
                while (lastId.next())
                    order.setId(lastId.getInt(1));
            }

            new OrderItemDao().save(order);

            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(IDominio domain) {
        order = (Order) domain;
        Connection conn = null;

        sql = "DELETE FROM \"orders\" WHERE id=?";
        try {
            conn = Connect.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, order.getId());
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
        order = (Order) domain;
        conn = null;

        sql = "SELECT * FROM \"orders\" WHERE id=" + order.getId();

        try {
            conn = Connect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            order = new Order();

            while (rs.next()) {
                order.setId(rs.getInt("id"));
                order.setDate_order(rs.getObject("date_order", LocalDateTime.class));
                order.setTotal_value(rs.getDouble("total_value"));
                Client client = new Client();
                client.setId(rs.getInt("client_id"));
                order.setClient((Client) new ClientDao().search(client));
                Collaborator collaborator = new Collaborator();
                collaborator.setId(rs.getInt("collaborator_id"));
                order.setCollaborator((Collaborator) new CollaboratorDao().search(collaborator));
                Payment payment = new Payment();
                payment.setId(rs.getInt("payment_id"));
                order.setPayment(payment);

                List<Order_Item> ListOrder = new ArrayList<Order_Item>();
                for (IDominio d : new OrderItemDao().list(order)) {
                    ListOrder.add((Order_Item) d);
                }
                order.setOrder_items(ListOrder);

                return order;
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
        order = (Order) domain;
        conn = null;

        sql = "SELECT * FROM \"orders\"";

        try {
            conn = Connect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            orderList = new ArrayList<IDominio>();
            while (rs.next()) {
                order = new Order();
                order.setId(rs.getInt("id"));
                order.setDate_order(rs.getObject("date_order", LocalDateTime.class));
                order.setTotal_value(rs.getDouble("total_value"));
                Client client = new Client();
                client.setId(rs.getInt("client_id"));
                order.setClient((Client) new ClientDao().search(client));
                Collaborator collaborator = new Collaborator();
                collaborator.setId(rs.getInt("collaborator_id"));
                order.setCollaborator((Collaborator) new CollaboratorDao().search(collaborator));
                Payment payment = new Payment();
                payment.setId(rs.getInt("payment_id"));
                order.setPayment(payment);

                orderList.add(order);
            }
            return orderList;

        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            Connect.close(conn);
        }

        return null;
    }
}
