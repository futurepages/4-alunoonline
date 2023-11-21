package modules.escola.dao;

import modules.escola.beans.Aluno;
import modules.escola.beans.Professor;
import modules.escola.beans.Turma;
import modules.escola.enums.TipoFiltroProfessorTurmaEnum;
import org.futurepages.core.persistence.Dao;
import org.futurepages.core.persistence.HQLProvider;
import org.futurepages.util.Is;

import java.util.List;

public class ProfessorDao extends HQLProvider {

	private static final String DEFAULT_ORDER = asc("nome_professor");
	private static List<Turma> turmas;

	public static Professor getById(int id) {
		return Dao.getInstance().get(Professor.class,id);
	}

	public static List<Professor> listAll() {
		return Dao.getInstance().list(hql(Professor.class,null, DEFAULT_ORDER));
	}

	public static List<Professor> listByTurmaId(int turma) {
		return Dao.getInstance().list(hql(Professor.class, Is.selected(turma)? field("turma.id").equalsTo(turma) : "" ,DEFAULT_ORDER));
	}

	public static boolean getOutroComMatriculaDeste(String matricula) {
		Professor professorVerificacao = Dao.getInstance().uniqueResult(hql(Professor.class, field("matricula").equalsTo(matricula)));
		Aluno alunoVerificacao = Dao.getInstance().uniqueResult(hql(Aluno.class, field("matricula").equalsTo(matricula)));

		if (alunoVerificacao != null || professorVerificacao != null){
			return true;
		} else {
			return false;
		}
	}

	public static List<Professor> listByTurmaIdAndTipoFiltro(TipoFiltroProfessorTurmaEnum tipoFiltro, Turma turma) {
		List professores = tipoFiltro!=null||turma!=null? Dao.getInstance().list(hql("p", Turma.class, "t", tipoFiltro!=null? " RIGHT " : " INNER ", join("t.professor") + as("p"),
								ands(
											turma!=null? field("t.id").equalsTo(turma.getId()) : "",
									        tipoFiltro!=null? tipoFiltro.getWhereHQL() : ""
								),
								DEFAULT_ORDER
						)
				): listAll();

		return professores;
	}
}

