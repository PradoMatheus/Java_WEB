package br.com.fatec.web.view_helper;

import br.com.fatec.web.domain.Category;
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
        String operation = req.getParameter("operation");
        Product product = new Product();

        if (operation.equals("save")) {
            product.setId(Integer.parseInt(req.getParameter("txtCod").trim()));
            product.setName(req.getParameter("txtName"));
            product.setDescription(req.getParameter("txtDescription"));
            product.setEan(req.getParameter("txtEAN"));

            Category category = new Category();
            category.setId(Integer.parseInt(req.getParameter("txtCategory")));
            product.setCategory(category);

            product.setValue(Double.parseDouble(req.getParameter("txtValue").replace(".", "").replace(",", ".")));
            product.setActive(Boolean.parseBoolean(req.getParameter("txtEnable")));
        } else if (operation.equals("search")) {
            product.setId(Integer.parseInt(req.getParameter("id")));
        } else if (operation.equals("delete")) {
            product.setId(Integer.parseInt(req.getParameter("txtCod")));
        }

        return product;
    }

    @Override
    public void setDominio(HttpServletRequest req, HttpServletResponse resp, Result result) {
        String operation = req.getParameter("operation");

        if (operation.equals("save") || operation.equals("delete")) {
            try {
                req.getRequestDispatcher("product?operation=list").forward(req, resp);
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
