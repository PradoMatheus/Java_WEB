package br.com.fatec.web.view_helper;

import br.com.fatec.web.domain.IDominio;
import br.com.fatec.web.domain.Role;
import br.com.fatec.web.util.Result;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RoleVh implements IViewHelper {
    @Override
    public IDominio getDominio(HttpServletRequest req) {
        String operation = req.getParameter("operation");
        Role role = new Role();

        if (operation.equals("save")) {
            role.setId(Integer.parseInt(req.getParameter("txtCod").trim()));
            role.setName(req.getParameter("txtName"));
            role.setObservation(req.getParameter("txtObs"));
            role.setActive(Boolean.parseBoolean(req.getParameter("txtEnable")));
        } else if (operation.equals("search")) {
            role.setId(Integer.parseInt(req.getParameter("id")));
        } else if (operation.equals("delete")) {
            role.setId(Integer.parseInt(req.getParameter("txtCod")));
        }

        return role;
    }

    @Override
    public void setDominio(HttpServletRequest req, HttpServletResponse resp, Result result) {
        String operation = req.getParameter("operation");

        if (operation.equals("save") || operation.equals("delete")) {
            try {
                req.getRequestDispatcher("role?operation=list").forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (operation.equals("list")) {
            List<Role> roleList = new ArrayList<Role>();
            for (IDominio d : result.getDominioList()) {
                roleList.add((Role) d);
            }
            req.setAttribute("roleList", roleList);

            try {
                req.getRequestDispatcher("role_list.jsp").forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (operation.equals("search")) {
            req.setAttribute("role", (Role) result.getDominio());

            try {
                req.getRequestDispatcher("role.jsp").forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
