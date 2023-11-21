package init;


import org.futurepages.menta.actions.FreeAction;

import java.util.Calendar;

/**
 * Ação Inicial da Aplicação
 */
public class Index extends FreeAction {

    @Override
    public String execute(){
        output("mensagemInicial", "Seja bem-vindo.");
	    output("momentoAtual",Calendar.getInstance());
        output("resumo", "Esse é um projeto para iniciantes em Futurepages 4.\nTrata-se de um projeto com código bem simples e regras de negócios bem simples, com o objetivo de familiarizar o desenvolvedor com um projeto baseado no Futurepages4.");
        return SUCCESS;
    }
}