package br.com.fatec.web.command;

import br.com.fatec.web.fachada.Fachada;
import br.com.fatec.web.fachada.IFachada;

public abstract class AbstractCommand implements ICommand {
    protected IFachada fachada = new Fachada();
}
