package br.com.fatec.web.command;

import br.com.fatec.web.domain.IDominio;
import br.com.fatec.web.util.Result;

public class DeleteCommand extends AbstractCommand {
    @Override
    public Result execute(IDominio domain) {
        return fachada.delete(domain);
    }
}
