package br.com.fatec.web.view_helper;

import br.com.fatec.web.domain.IDominio;
import br.com.fatec.web.domain.Order;
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
        Order order = new Order();
        return order;
    }

    @Override
    public void setDominio(HttpServletRequest req, HttpServletResponse resp, Result result) {
        String operation = req.getParameter("operation");

        if (operation.equals("save")) {
            try {
                req.getRequestDispatcher("order.jsp").forward(req, resp);
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
