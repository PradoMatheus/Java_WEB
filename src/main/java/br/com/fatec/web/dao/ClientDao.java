package br.com.fatec.web.dao;

import br.com.fatec.web.domain.Client;
import br.com.fatec.web.domain.IDominio;

import java.util.ArrayList;
import java.util.List;

public class ClientDao implements IDAO {
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
        Client client = new Client();
        client.setId(1);
        client.setName("Matheus Prado");
        client.setActive(true);
        client.setEmail("pradomatheus.19@hotmail.com");
        client.setCpf(1234678912L);

        return client;
    }

    @Override
    public List<IDominio> list(IDominio domain) {
        List<IDominio> clientList = new ArrayList<IDominio>();

        Client client = new Client();
        client.setId(0);
        client.setName("Matheus Prado");
        client.setActive(true);
        client.setEmail("pradomatheus.19@hotmail.com");
        client.setCpf(1234678912L);

        clientList.add(
                client
        );

        return clientList;
    }
}
