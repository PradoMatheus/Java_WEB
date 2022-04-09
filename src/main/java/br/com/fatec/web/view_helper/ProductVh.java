package br.com.fatec.web.view_helper;

import br.com.fatec.web.domain.IDominio;
import br.com.fatec.web.domain.Product;
import br.com.fatec.web.util.Result;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductVh implements IViewHelper {
    @Override
    public IDominio getDominio(HttpServletRequest req) {
        Product product = new Product();
        return product;
    }

    @Override
    public void setDominio(HttpServletRequest req, HttpServletResponse resp, Result result) {
        String operation = req.getParameter("operation");

        if (operation.equals("save")) {
            try {
                req.getRequestDispatcher("product.jsp").forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (operation.equals("list")) {
            List<Product> productList = new ArrayList<Product>();
            for (IDominio d : result.getDominioList()) {
                productList.add((Product) d);
            }
            req.setAttribute("productList", productList);

            try {
                req.getRequestDispatcher("product_list.jsp").forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (operation.equals("search")) {
            req.setAttribute("product", (Product) result.getDominio());

            try {
                req.getRequestDispatcher("product.jsp").forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
