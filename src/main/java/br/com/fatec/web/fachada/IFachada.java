package br.com.fatec.web.fachada;

import br.com.fatec.web.domain.IDominio;
import br.com.fatec.web.util.Result;

public interface IFachada {
    Result save(IDominio dominio);

    Result delete(IDominio dominio);

    Result search(IDominio dominio);

    Result list(IDominio dominio);
}
