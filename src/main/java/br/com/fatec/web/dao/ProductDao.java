package br.com.fatec.web.dao;

import br.com.fatec.web.domain.IDominio;

import java.util.List;

public class ProductDao implements IDAO {
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
        return null;
    }

    @Override
    public List<IDominio> list(IDominio domain) {
        return null;
    }
}
