package br.com.fatec.web.fachada;

import br.com.fatec.web.dao.*;
import br.com.fatec.web.domain.*;
import br.com.fatec.web.util.Result;

import java.util.HashMap;
import java.util.Map;

public class Fachada implements IFachada {

    private Result result;
    private Map<String, IDAO> mapDao;

    public Fachada() {
        result = new Result();
        mapDao = new HashMap<String, IDAO>();

        mapDao.put(Category.class.getName(), new CategoryDao());
        mapDao.put(Client.class.getName(), new ClientDao());
        mapDao.put(Collaborator.class.getName(), new CollaboratorDao());
        mapDao.put(Order.class.getName(), new OrderDao());
        mapDao.put(Product.class.getName(), new ProductDao());
        mapDao.put(Role.class.getName(), new RoleDao());
    }

    @Override
    public Result save(IDominio domain) {
        IDAO idao = mapDao.get(domain.getClass().getName());
        idao.save(domain);

        return result;
    }

    @Override
    public Result delete(IDominio domain) {
        IDAO idao = mapDao.get(domain.getClass().getName());
        idao.delete(domain);

        return result;
    }

    @Override
    public Result search(IDominio domain) {
        IDAO idao = mapDao.get(domain.getClass().getName());
        result.setDominio(idao.search(domain));

        return result;
    }

    @Override
    public Result list(IDominio domain) {
        IDAO idao = mapDao.get(domain.getClass().getName());
        result.setDominioList(idao.list(domain));

        return result;
    }
}
