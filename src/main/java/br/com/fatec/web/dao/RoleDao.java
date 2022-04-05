package br.com.fatec.web.dao;

import br.com.fatec.web.domain.IDominio;
import br.com.fatec.web.domain.Role;

import java.util.ArrayList;
import java.util.List;

public class RoleDao implements IDAO {
    @Override
    public boolean save(IDominio domain) {
        return false;
    }

    @Override
    public boolean delete(IDominio domain) {
        return false;
    }

    @Override
    public IDominio search(IDominio domain) {
        Role role = new Role();
        role.setId(1);
        role.setName("TI");
        role.setObservation("Responsável pela TI");
        role.setActive(true);

        return role;
    }

    @Override
    public List<IDominio> list(IDominio domain) {
        List<IDominio> roleList = new ArrayList<IDominio>();

        Role role = new Role();
        role.setId(1);
        role.setName("TI");
        role.setObservation("Responsável pela TI");
        role.setActive(true);

        roleList.add(role);

        return roleList;
    }
}
