package br.com.fatec.web.view_helper;

import br.com.fatec.web.domain.Category;
import br.com.fatec.web.domain.IDominio;
import br.com.fatec.web.util.Result;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CategoryVh implements IViewHelper {
    @Override
    public IDominio getDominio(HttpServletRequest req) {
        String operation = req.getParameter("operation");
        Category category = new Category();

        if (operation.equals("save")) {

            category.setId(Integer.parseInt(req.getParameter("txtCod").trim()));
            category.setName(req.getParameter("txtName"));
            category.setObservation(req.getParameter("txtObs"));
        }

        return category;
    }

    @Override
    public void setDominio(HttpServletRequest req, HttpServletResponse resp, Result result) {
        String operation = req.getParameter("operation");

        if (operation.equals("save")) {
            try {
                req.getRequestDispatcher("category?operation=list").forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (operation.equals("list")) {
            List<Category> categoryList = new ArrayList<Category>();
            for (IDominio d : result.getDominioList()) {
                categoryList.add((Category) d);
            }
            req.setAttribute("categoryList", categoryList);

            try {
                req.getRequestDispatcher("category_list.jsp").forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (operation.equals("search")) {
            req.setAttribute("category", (Category) result.getDominio());

            try {
                req.getRequestDispatcher("category.jsp").forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
