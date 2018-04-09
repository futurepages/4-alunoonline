package modules.escola.install;

import modules.escola.beans.TipoTurma;
import org.futurepages.core.install.Installer;
import org.futurepages.core.persistence.Dao;

/*
 * Instala os tipos de turma...
 */
public class TiposTurma extends Installer{

    @Override
    public void execute() throws Exception {
	    Dao.getInstance().save(new TipoTurma("Turma Matinal"));
	    Dao.getInstance().save(new TipoTurma("Turma Vespertina"));
	    Dao.getInstance().save(new TipoTurma("Turma Matutino"));
	    Dao.getInstance().save(new TipoTurma("Turma Pré-Matutino"));
	    Dao.getInstance().save(new TipoTurma("Turma Integral"));
    }
}