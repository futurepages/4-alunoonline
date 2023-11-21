package install.escola;

import install.Resources;
import modules.escola.beans.Professor;
import modules.escola.beans.Turma;
import org.futurepages.core.install.Installation;
import org.futurepages.core.persistence.Dao;
import org.futurepages.enums.PathTypeEnum;
import org.futurepages.util.FileUtil;

import java.io.IOException;
import java.util.List;

public class Professores implements Installation {

	private List<Turma> listaTurmaWithAluno;

	public Professores() {
	}
	public Professores(List<Turma> listaTurmaWithAluno) {
		this.listaTurmaWithAluno = listaTurmaWithAluno;
	}

//	private int i = 1;

	@Override
	public void execute() throws IOException {

//		installProfessor("ChatGpt", "93P0000000", "Infinito", listaTurmaWithAluno.get(i));
//		installProfessor("Olberto Einstem", "93P0000001", "Mestrado", listaTurmaWithAluno.get(i));
//		installProfessor("Nicolau Telos", "93P0000002", "Mestrado", listaTurmaWithAluno.get(i));
//		installProfessor("Billo Gatos", "93P0000004", "Mestrado", listaTurmaWithAluno.get(i));
//		installProfessor("Severino Jobis", "93P0000005", "Mestrado", listaTurmaWithAluno.get(i));
//		installProfessor("Grase Murrai Hobber", "93P0000007", "Mestrado", listaTurmaWithAluno.get(i));
//
		installProfessor("ChatGpt", "93P0000000", "Infinito");
		installProfessor("Olberto Einstem", "93P0000001", "Mestrado");
		installProfessor("Nicolau Telos", "93P0000002", "Mestrado");
		installProfessor("Billo Gatos", "93P0000004", "Mestrado");
		installProfessor("Severino Jobis", "93P0000005", "Mestrado");
		installProfessor("Grase Murrai Hobber", "93P0000007", "Mestrado");

	}

	private void installProfessor(String nome_professor, String matricula, String graduacao) throws IOException {
			Professor professor = new Professor(nome_professor, matricula, graduacao);
			Dao.getInstance().save(professor);

//		Professor professor = new Professor();
//		if (i < listaTurmaWithAluno.size() && turma.getProfessor() == null){
//			professor = new Professor(nome_professor, matricula, graduacao, turma);
//			Dao.getInstance().save(professor);
//			turma.setProfessor(professor);
//		} else {
//			professor = new Professor(nome_professor, matricula, graduacao);
//			Dao.getInstance().save(professor);
//		}

//		for (Turma turma: listaTurma) {
//			if (turma.getAlunos() == null){
//				turma.setProfessor(professor);
//				Dao.getInstance().update(turma);
//				break;
//			}
//		}

		FileUtil.copy(FileUtil.classRealPath(this.getClass()) + "res/Professor/" + professor.getId() + ".jpg", Resources.getUploadsPath(PathTypeEnum.REAL) + "/professores/" + professor.getId()+".jpg");
//		i++;
	}

}
