package br.com.fatec.web.dao;

import br.com.fatec.web.domain.Collaborator;
import br.com.fatec.web.domain.IDominio;
import br.com.fatec.web.domain.Role;

import java.util.ArrayList;
import java.util.List;

public class CollaboratorDao implements IDAO {
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
        Collaborator collaborator = new Collaborator();
        collaborator.setId(1);
        collaborator.setName("Matheus Prado");
        Role role = new Role();
        role.setName("Gerente");
        collaborator.setRole(role);
        collaborator.setEmail("teste@email");
        collaborator.setActive(true);

        return collaborator;
    }

    @Override
    public List<IDominio> list(IDominio domain) {
        List<IDominio> collaboratorList = new ArrayList<IDominio>();

        Collaborator collaborator = new Collaborator();
        collaborator.setId(1);
        collaborator.setName("Matheus");
        Role role = new Role();
        role.setName("Gerente");
        collaborator.setRole(role);
        collaborator.setEmail("teste@email");
        collaborator.setActive(true);

        collaboratorList.add(collaborator);

        return collaboratorList;
    }
}
