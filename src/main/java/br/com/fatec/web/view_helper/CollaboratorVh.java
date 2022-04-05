package br.com.fatec.web.view_helper;

import br.com.fatec.web.domain.Collaborator;
import br.com.fatec.web.domain.IDominio;
import br.com.fatec.web.util.Result;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CollaboratorVh implements IViewHelper {
    @Override
    public IDominio getDominio(HttpServletRequest req) {
        Collaborator collaborator = new Collaborator();
        return collaborator;
    }

    @Override
    public void setDominio(HttpServletRequest req, HttpServletResponse resp, Result result) {
        String operation = req.getParameter("operation");

        if (operation.equals("save")) {
            try {
                req.getRequestDispatcher("collaborator.jsp").forward(req, resp);
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
            req.setAttribute("collaboratorList", collaboratorList);

            try {
                req.getRequestDispatcher("collaborator_list.jsp").forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
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
