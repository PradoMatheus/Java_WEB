package br.com.fatec.web.view_helper;


import br.com.fatec.web.domain.Client;
import br.com.fatec.web.domain.IDominio;
import br.com.fatec.web.util.Result;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClientVh implements IViewHelper {
    @Override
    public IDominio getDominio(HttpServletRequest req) {
        String operation = req.getParameter("operation");
        Client client = new Client();

        if (operation.equals("save")) {
            client.setId(Integer.parseInt(req.getParameter("txtCod").trim()));
            client.setName(req.getParameter("txtName"));
            client.setCpf(Long.parseLong(req.getParameter("txtCPF").replaceAll("[-+.^:,]", "").trim()));
            client.setEmail(req.getParameter("txtEmail"));
            client.setActive(Boolean.parseBoolean(req.getParameter("txtEnable")));
            client.setDistrict(req.getParameter("txtNeighborhood"));
            client.setAddress(req.getParameter("txtAddress"));
            client.setCity(req.getParameter("txtCity"));
            client.setZip(Integer.parseInt(req.getParameter("txtZIP").replaceAll("[-+.^:,]", "").trim()));
            client.setCellphone(Long.parseLong(req.getParameter("txtPhone").replaceAll("[-+.^:,()]", "").replace(" ", "").trim()));
            client.setNumber_house(Integer.parseInt(req.getParameter("txtNumber").trim()));
        } else if (operation.equals("search")) {
            client.setId(Integer.parseInt(req.getParameter("id").trim()));
        } else if (operation.equals("delete")) {
            client.setId(Integer.parseInt(req.getParameter("txtCod")));
        }

        return client;
    }

    @Override
    public void setDominio(HttpServletRequest req, HttpServletResponse resp, Result result) {
        String operation = req.getParameter("operation");

        if (operation.equals("save") || operation.equals("delete")) {
            try {
                req.getRequestDispatcher("client?operation=list&type=normal").forward(req, resp);
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
                req.setAttribute("clientList", clientList);

                try {
                    req.getRequestDispatcher("client_list.jsp").forward(req, resp);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
