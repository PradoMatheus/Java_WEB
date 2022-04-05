package br.com.fatec.web.util;

import br.com.fatec.web.domain.IDominio;

import java.util.List;

public class Result {
    private IDominio dominio;
    private List<IDominio> dominioList;
    private String mensage;

    public IDominio getDominio() {
        return dominio;
    }

    public void setDominio(IDominio dominio) {
        this.dominio = dominio;
    }

    public List<IDominio> getDominioList() {
        return dominioList;
    }

    public void setDominioList(List<IDominio> dominioList) {
        this.dominioList = dominioList;
    }

    public String getMensage() {
        return mensage;
    }

    public void setMensage(String mensage) {
        this.mensage = mensage;
    }
}
