package modules.escola.dao;

import modules.escola.beans.Aluno;
import modules.escola.beans.Professor;
import modules.escola.beans.Turma;
import modules.escola.enums.TipoFiltroAlunoTurmaEnum;
import org.futurepages.core.persistence.Dao;
import org.futurepages.core.persistence.HQLProvider;
import org.futurepages.util.Is;

import java.util.List;


public class AlunoDao extends HQLProvider{

	private static final String  DEFAULT_ORDER = asc("nomeCompleto");

	public static List<Aluno> listByTurmaId(int turma) {
		return Dao.getInstance().list(hql(Aluno.class, Is.selected(turma)? field("turma").equalsTo(turma) : "" ,DEFAULT_ORDER));
	}

	public static Aluno getById(int id) {
		return Dao.getInstance().get(Aluno.class,id);
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

	public static List<Aluno> listAll() {
		return Dao.getInstance().list(hql(Aluno.class,null, DEFAULT_ORDER));
	}

	public static List<Aluno> listByTurmaIdAndTipoFiltro(Turma turma, TipoFiltroAlunoTurmaEnum tipoFiltro) {
		return Dao.getInstance().list(hql(Aluno.class,
											ands(
												turma!=null? field("turma").equalsTo(turma) : "",
												tipoFiltro!=null? tipoFiltro.getWhereHQL() : ""
											),
											DEFAULT_ORDER
								)
		);
	}
}