package br.com.fatec.web.view_helper;


import br.com.fatec.web.domain.Client;
import br.com.fatec.web.domain.IDominio;
import br.com.fatec.web.util.Result;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClientVh implements IViewHelper {
    @Override
    public IDominio getDominio(HttpServletRequest req) {
        Client client = new Client();
        return client;
    }

    @Override
    public void setDominio(HttpServletRequest req, HttpServletResponse resp, Result result) {
        String operation = req.getParameter("operation");

        if (operation.equals("save")) {
            try {
                req.getRequestDispatcher("client.jsp").forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (operation.equals("list")) {
            List<Client> clientList = new ArrayList<Client>();
            for (IDominio d : result.getDominioList()) {
                clientList.add((Client) d);
            }
            req.setAttribute("clientList", clientList);

            try {
                req.getRequestDispatcher("client_list.jsp").forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (operation.equals("search")) {
            req.setAttribute("client", (Client) result.getDominio());

            try {
                req.getRequestDispatcher("client.jsp").forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
