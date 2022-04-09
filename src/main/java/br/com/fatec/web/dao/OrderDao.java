package br.com.fatec.web.dao;

import br.com.fatec.web.domain.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderDao implements IDAO {
    @Override
    public boolean save(IDominio domain) {
        return false;
    }

    @Override
    public boolean delete(IDominio domain) {
        return false;
    }

    @Override
    public IDominio search(IDominio domain) {
        Order order = new Order();
        order.setId(1);

        Client client = new Client();
        client.setName("Mateus");
        order.setClient(client);

        Collaborator collaborator = new Collaborator();
        collaborator.setName("Melo");
        order.setCollaborator(collaborator);

        Payment payment = new Payment();
        payment.setName("Dinheiro");
        order.setPayment(payment);

        order.setTotal_value(75.00);
        order.setDate_order(LocalDateTime.now());

        Order_Item order_item = new Order_Item();
        Product product = new Product();
        product.setId(1);
        product.setName("Coca Cola 1L");
        order_item.setProduct(product);
        order_item.setQuantity(5);
        List<Order_Item> order_items = new ArrayList<Order_Item>();
        order_items.add(order_item);
        order.setOrder_items(order_items);

        return order;
    }

    @Override
    public List<IDominio> list(IDominio domain) {
        List<IDominio> orderList = new ArrayList<IDominio>();

        Order order = new Order();
        order.setId(1);

        Client client = new Client();
        client.setName("Matheus");
        order.setClient(client);

        Collaborator collaborator = new Collaborator();
        collaborator.setName("Prado");
        order.setCollaborator(collaborator);

        Payment payment = new Payment();
        payment.setName("PIX");
        order.setPayment(payment);

        order.setTotal_value(158.00);
        order.setDate_order(LocalDateTime.now());

        Order_Item order_item = new Order_Item();
        Product product = new Product();
        product.setId(1);
        product.setName("Coca Cola 2L");
        order_item.setProduct(product);
        order_item.setQuantity(5);
        List<Order_Item> order_items = new ArrayList<Order_Item>();
        order_items.add(order_item);
        order.setOrder_items(order_items);

        orderList.add(order);

        return orderList;
    }
}
