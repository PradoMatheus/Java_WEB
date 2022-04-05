package br.com.fatec.web.view_helper;

import br.com.fatec.web.domain.IDominio;
import br.com.fatec.web.domain.Order;
import br.com.fatec.web.domain.Order_Item;
import br.com.fatec.web.util.Result;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderVh implements IViewHelper {
    @Override
    public IDominio getDominio(HttpServletRequest req) {
        Order order = new Order();
        return order;
    }

    @Override
    public void setDominio(HttpServletRequest req, HttpServletResponse resp, Result result) {
        try {
            req.getRequestDispatcher("category.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
