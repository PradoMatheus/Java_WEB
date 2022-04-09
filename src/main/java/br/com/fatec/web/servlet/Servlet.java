package br.com.fatec.web.servlet;

import br.com.fatec.web.command.*;
import br.com.fatec.web.domain.IDominio;
import br.com.fatec.web.util.Result;
import br.com.fatec.web.view_helper.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = {"/category", "/client", "/collaborator", "/order", "/product", "/role"})
public class Servlet extends HttpServlet {
    private Map<String, IViewHelper> mapVh;
    private Map<String, ICommand> mapCommand;

    public void init() {
        mapVh = new HashMap<>();
        mapVh.put("/WEB_war_exploded/category", new CategoryVh());
        mapVh.put("/WEB_war_exploded/client", new ClientVh());
        mapVh.put("/WEB_war_exploded/collaborator", new CollaboratorVh());
        mapVh.put("/WEB_war_exploded/order", new OrderVh());
        mapVh.put("/WEB_war_exploded/order_item", new Order_ItemVh());
        mapVh.put("/WEB_war_exploded/payment", new PaymentVh());
        mapVh.put("/WEB_war_exploded/product", new ProductVh());
        mapVh.put("/WEB_war_exploded/role", new RoleVh());

        mapCommand = new HashMap<String, ICommand>();
        mapCommand.put("save", new SaveCommand());
        mapCommand.put("delete", new DeleteCommand());
        mapCommand.put("list", new ListCommand());
        mapCommand.put("search", new SearchCommand());
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        execute(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        execute(req, res);
    }

    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException {
        IViewHelper iViewHelper = mapVh.get(req.getRequestURI());
        IDominio domain = iViewHelper.getDominio(req);
        String operation = req.getParameter("operation");
        ICommand command = mapCommand.get(operation);
        Result result = command.execute(domain);
        iViewHelper.setDominio(req, res, result);
    }

    public void destroy() {
    }
}