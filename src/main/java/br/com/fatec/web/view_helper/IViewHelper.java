package br.com.fatec.web.view_helper;

import br.com.fatec.web.domain.IDominio;
import br.com.fatec.web.util.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IViewHelper {

    public IDominio getDominio(HttpServletRequest req);

    public void setDominio(HttpServletRequest req, HttpServletResponse resp, Result result);
}
