package modules.escola.actions;

import modules.escola.beans.Aluno;
import modules.escola.beans.Professor;
import modules.escola.beans.Turma;
import modules.escola.dao.AlunoDao;
import modules.escola.dao.ProfessorDao;
import modules.escola.dao.TipoTurmaDao;
import modules.escola.dao.TurmaDao;
import modules.escola.enums.TipoFiltroAlunoTurmaEnum;
import modules.escola.enums.TipoFiltroTurmaProfessorEnum;
import modules.escola.enums.TipoFiltroTurmaRepresentanteEnum;
import modules.escola.validators.TurmaValidator;
import org.futurepages.core.persistence.Dao;
import org.futurepages.core.persistence.annotations.Transactional;
import org.futurepages.menta.actions.CrudActions;
import org.futurepages.util.Is;

import java.util.List;

//Crud Actions de Turma
public class TurmaActions extends CrudActions {

	@Override
	protected void restoreObject() {
		Turma turma = (Turma) input.getValue("turma");
		output("turma", Dao.getInstance().get(Turma.class, turma.getId()));
	}

	@Override
	protected void listDependencies() {
		Turma turma = (Turma) input.getValue("turma");
		//quando tem erro no formulário, para recarregar a tela, deve-se colocar novamente o objeto no output.
		if (hasError()) {
			output("turma", turma);
		}

		output("tipos", TipoTurmaDao.listAll());
		output("alunos", AlunoDao.listByTurmaId(turma.getId()));
		output("professores", ProfessorDao.listAll());
	}

	public String create() {
		Turma turma = (Turma) input.getValue("turma");
		validate(TurmaValidator.class).createOrUpdate(turma);
		Professor professor = turma.getProfessor();
		Dao.getInstance().saveTransaction(turma);
		return success("Turma criada com sucesso.");
	}

	public String update() {
		Turma turmaForm = (Turma) input.getValue("turma");
		validate(TurmaValidator.class).createOrUpdate(turmaForm);
		Turma turmaDB = TurmaDao.getById(turmaForm.getId());
		turmaDB.fillFromForm(turmaForm);
		Dao.getInstance().updateTransaction(turmaDB);
		return success("Turma atualizada com sucesso.");
	}

	public String delete() {
		Turma turma = (Turma) input.getValue("turma");

		turma = TurmaDao.getById(turma.getId());
		Dao.getInstance().deleteTransaction(turma);
		return success("Turma excluída com sucesso.");
	}

	public String explore(String busca, String tipoFiltro, String tipoFiltroProfessor){
		TipoFiltroTurmaRepresentanteEnum tipoFiltroTurmaRepresentanteEnum = null;
		TipoFiltroTurmaProfessorEnum TipoFiltroTurmaProfessorEnum = null;
		try {
			tipoFiltroTurmaRepresentanteEnum = TipoFiltroTurmaRepresentanteEnum.valueOf(tipoFiltro);
		}catch (Exception ignored){}

		try {
			TipoFiltroTurmaProfessorEnum = TipoFiltroTurmaProfessorEnum.valueOf(tipoFiltroProfessor);
		}catch (Exception ignored){}

		output("professores", ProfessorDao.listAll());
		output("turmas", TurmaDao.listByWithFilter(busca, tipoFiltroTurmaRepresentanteEnum, TipoFiltroTurmaProfessorEnum));
		output("busca",busca);

		TipoFiltroTurmaRepresentanteEnum[] opcoesFiltroTurma = tipoFiltroTurmaRepresentanteEnum.values();
		output("opcoesFiltroTurma", opcoesFiltroTurma);

		TipoFiltroTurmaProfessorEnum[] opcoesFiltroProfessor = TipoFiltroTurmaProfessorEnum.values();
		output("opcoesFiltroProfessor", opcoesFiltroProfessor);

		return SUCCESS;
	}

	@Override
	protected void listObjects() {
		explore("", null, null);
	}

}
