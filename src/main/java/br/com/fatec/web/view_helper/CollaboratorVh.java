package br.com.fatec.web.view_helper;

import br.com.fatec.web.domain.Collaborator;
import br.com.fatec.web.domain.IDominio;
import br.com.fatec.web.domain.Role;
import br.com.fatec.web.util.Result;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CollaboratorVh implements IViewHelper {
    @Override
    public IDominio getDominio(HttpServletRequest req) {
        String operation = req.getParameter("operation");
        Collaborator collaborator = new Collaborator();


        if (operation.equals("save")) {
            collaborator.setId(Integer.parseInt(req.getParameter("txtCod").trim()));
            collaborator.setName(req.getParameter("txtName"));

            Role role = new Role();
            role.setId(Integer.parseInt(req.getParameter("txtJob").trim()));
            collaborator.setRole(role);

            collaborator.setEmail(req.getParameter("txtEmail"));
            collaborator.setObservation(req.getParameter("txtObs"));
            collaborator.setActive(Boolean.parseBoolean(req.getParameter("txtEnable")));
        } else if (operation.equals("search")) {
            collaborator.setId(Integer.parseInt(req.getParameter("id").trim()));
        } else if (operation.equals("delete")) {
            collaborator.setId(Integer.parseInt(req.getParameter("txtCod")));
        }

        return collaborator;
    }

    @Override
    public void setDominio(HttpServletRequest req, HttpServletResponse resp, Result result) {
        String operation = req.getParameter("operation");

        if (operation.equals("save") || operation.equals("delete")) {
            try {
                req.getRequestDispatcher("collaborator?operation=list&type=normal").forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (operation.equals("list")) {
            List<Collaborator> collaboratorList = new ArrayList<Collaborator>();
            for (IDominio d : result.getDominioList()) {
                collaboratorList.add((Collaborator) d);
            }

            if (req.getParameter("type").equals("gson")) {
                String json = new Gson().toJson(result.getDominioList());

                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");

                try {
                    resp.getWriter().write(json);
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            } else {
                req.setAttribute("collaboratorList", collaboratorList);

                try {
                    req.getRequestDispatcher("collaborator_list.jsp").forward(req, resp);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else if (operation.equals("search")) {
            req.setAttribute("collaborator", (Collaborator) result.getDominio());

            try {
                req.getRequestDispatcher("collaborator.jsp").forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
