package br.com.fatec.web.dao;

import br.com.fatec.web.domain.IDominio;

import java.util.List;

public interface IDAO {

    public boolean save(IDominio domain);

    public boolean delete(IDominio domain);

    public IDominio search(IDominio domain);

    public List<IDominio> list(IDominio domain);
}
