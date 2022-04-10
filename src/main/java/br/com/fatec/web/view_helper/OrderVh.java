package br.com.fatec.web.view_helper;

import br.com.fatec.web.domain.*;
import br.com.fatec.web.util.Result;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderVh implements IViewHelper {
    @Override
    public IDominio getDominio(HttpServletRequest req) {
        String operation = req.getParameter("operation");
        Order order = new Order();

        if (operation.equals("save")) {
            order.setId(Integer.parseInt(req.getParameter("txtCod").trim()));

            Client client = new Client();
            client.setId(Integer.parseInt(req.getParameter("selClient").trim()));
            order.setClient(client);

            Collaborator collaborator = new Collaborator();
            collaborator.setId(Integer.parseInt(req.getParameter("selVendor").trim()));
            order.setCollaborator(collaborator);

            Order_Item order_item = new Order_Item();
            Product product = new Product();
            product.setId(Integer.parseInt(req.getParameter("selProduct").trim()));
            order_item.setProduct(product);
            order_item.setValue(Double.parseDouble(req.getParameter("txtPrice").replace(".", "").replace(",", ".")));
            order_item.setQuantity(Integer.parseInt(req.getParameter("txtQuantity").trim()));

            Payment payment = new Payment();
            payment.setId(Integer.parseInt(req.getParameter("selPayment").trim()));
            order.setPayment(payment);

            order.setTotal_value(Double.parseDouble(req.getParameter("txtTotalValue").replace(".", "").replace(",", ".")));
        }

        return order;
    }

    @Override
    public void setDominio(HttpServletRequest req, HttpServletResponse resp, Result result) {
        String operation = req.getParameter("operation");

        if (operation.equals("save")) {
            try {
                req.getRequestDispatcher("order?operation=list").forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (operation.equals("list")) {
            List<Order> orderList = new ArrayList<Order>();
            for (IDominio d : result.getDominioList()) {
                orderList.add((Order) d);
            }
            req.setAttribute("orderList", orderList);

            try {
                req.getRequestDispatcher("order_list.jsp").forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (operation.equals("search")) {
            req.setAttribute("order", (Order) result.getDominio());

            try {
                req.getRequestDispatcher("order.jsp").forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
