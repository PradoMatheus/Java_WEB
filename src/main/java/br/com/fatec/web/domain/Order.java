package br.com.fatec.web.domain;

import java.util.List;

public class Order implements IDominio {
    private int id;
    private Client client;
    private Collaborator collaborator;
    private List<Order_Item> order_items;
    private Double total_value;
    private Payment payment;

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Collaborator getCollaborator() {
        return collaborator;
    }

    public void setCollaborator(Collaborator collaborator) {
        this.collaborator = collaborator;
    }

    public List<Order_Item> getOrder_items() {
        return order_items;
    }

    public void setOrder_items(List<Order_Item> order_items) {
        this.order_items = order_items;
    }

    public Double getTotal_value() {
        return total_value;
    }

    public void setTotal_value(Double total_value) {
        this.total_value = total_value;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
