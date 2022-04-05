package br.com.fatec.web.command;

import br.com.fatec.web.domain.IDominio;
import br.com.fatec.web.util.Result;

public interface ICommand {
    public Result execute(IDominio dominio);
}
