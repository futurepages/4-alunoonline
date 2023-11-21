package modules.escola.actions;

import install.Resources;
import modules.escola.beans.Aluno;
import modules.escola.beans.Professor;
import modules.escola.beans.Turma;
import modules.escola.dao.AlunoDao;
import modules.escola.dao.ProfessorDao;
import modules.escola.dao.TurmaDao;
import modules.escola.enums.TipoFiltroAlunoTurmaEnum;
import modules.escola.enums.TipoFiltroProfessorTurmaEnum;
import modules.escola.validators.AlunoValidator;
import modules.escola.validators.ProfessorValidator;
import org.apache.commons.fileupload.FileItem;
import org.futurepages.core.persistence.Dao;
import org.futurepages.core.persistence.annotations.Transactional;
import org.futurepages.enums.PathTypeEnum;
import org.futurepages.menta.actions.CrudActions;
import org.futurepages.util.Is;
import org.futurepages.util.The;

import java.io.File;
import java.util.List;

public class ProfessorActions extends CrudActions {

	/*
	 * É a execução da ação de criação. quando chama-se Professor.create.fpg
	 */
	@Transactional
	public String create() throws Exception {
		boolean jaPossuiTurma = false;

		Professor professor = (Professor) input.getValue("professor");
		FileItem foto = (FileItem) input.getValue("foto");
		validate(ProfessorValidator.class).dataCreate(professor, foto, CREATE);
		Dao.getInstance().save(professor);
		gravaFoto(professor, foto);
		int turmaId = Integer.parseInt((String) input.getValue("turma"));
		if (turmaId != 0){
			Turma turma = TurmaDao.getById(turmaId);
			if (turma.getProfessor() == null){
				turma.setProfessor(professor);
			} else {
				jaPossuiTurma = true;
			}
		}
		return success(jaPossuiTurma?"Professor atualizado com sucesso.\nA Turma já possui um Professor Responsável":"Professor atualizado com sucesso.");
	}

	/*
	 * Ação de atualização do Professor.  Professor.create.fpg
	 */
	@Transactional
	public String update() throws Exception {
		boolean jaPossuiTurma = false;

		Professor professor = (Professor) input.getValue("professor");
		FileItem foto = (FileItem) input.getValue("foto");
		validate(ProfessorValidator.class).dataUpdate(professor, foto, UPDATE);
		Dao.getInstance().update(professor);
		gravaFoto(professor, foto);
		int turmaId = Integer.parseInt((String) input.getValue("turma"));
		if (turmaId != 0){
			Turma turma = TurmaDao.getById(turmaId);
			if (turma.getProfessor() == null){
				turma.setProfessor(professor);
			} else {
				jaPossuiTurma = true;
			}
		}
		return success(jaPossuiTurma?"Professor atualizado com sucesso.\nA Turma já possui um Professor Responsável":"Professor atualizado com sucesso.");
	}

	/*
	 * Ação de deleção. Professor.delete.fpg
	 */
	@Transactional
	public String delete() {
		Professor professor = (Professor) input.getValue("professor");
		professor = ProfessorDao.getById(professor.getId());
		Dao.getInstance().delete(professor);
		return success("Professor excluído com sucesso.");
	}

	private void gravaFoto(Professor professor, FileItem foto) throws Exception {
		if(foto!=null){
			String uploadsPath = Resources.getUploadsPath(PathTypeEnum.REAL);
			String path = The.concat(uploadsPath, "/professores/", String.valueOf(professor.getId()),".jpg");
			File file = new File(path);
			foto.write(file);
		}
	}

	public String explore(int turmaId, String tipoFiltroName) {
		TipoFiltroProfessorTurmaEnum tipoFiltro = null;
		String instancia = null;

		try {
			tipoFiltro = TipoFiltroProfessorTurmaEnum.valueOf(tipoFiltroName);
		} catch (Exception ignored) {}

		// turma selecionada para filta
		Turma turma = Is.selected(turmaId)? Dao.getInstance().get(Turma.class, turmaId) : null;
		List<Professor> professores = ProfessorDao.listByTurmaIdAndTipoFiltro(tipoFiltro, turma);
		List<Turma> turmas = TurmaDao.listAll();
		// pega os valores que tem em filto Professor se 0 | 1
		TipoFiltroProfessorTurmaEnum[] opcoesFiltroProfessor = TipoFiltroProfessorTurmaEnum.values();

		output("professores", professores);
		output("turmas", turmas);
		output("opcoesFiltroProfessor", opcoesFiltroProfessor);
		output("ifTurmaUtilizadaNaFiltagem", turma);

		return SUCCESS;
	}

	/*
	 * listObjects() é a filtragem padrão da listagem.
	 * É o filtro default da listagem. Entenda quando é chamado em CrudActions.execute()
	 * É quando executado quando chama-se Professor.fpg?type=explore
	 */
	@Override
	protected void listObjects() {
		explore(0, "");
	}


	/*
	 * método que implementamos com a restauração do objeto do banco para a visão.
	 */
	@Override
	protected void restoreObject() {
		Professor professor = (Professor) input.getValue("professor");
		professor = ProfessorDao.getById(professor.getId());
		output("professor", professor);
	}

	@Override
	protected void listDependencies() {
		//quando tem erro no formulário, para recarregar a tela, deve-se colocar novamente o objeto no output.
		if(hasError()) {
			fwdValue("professor");
		}

		List<Turma> turmas = TurmaDao.listAll();
		output("turmas", turmas);
	}

}
