package modules.escola.dao;

import modules.escola.beans.Aluno;
import modules.escola.beans.Turma;
import modules.escola.enums.TipoFiltroTurmaProfessorEnum;
import modules.escola.enums.TipoFiltroTurmaRepresentanteEnum;
import org.futurepages.core.persistence.Dao;
import org.futurepages.core.persistence.HQLProvider;
import org.futurepages.util.Is;

import java.util.List;


public class TurmaDao extends HQLProvider {

	private static final String  DEFAULT_ORDER = asc("codigo");


	public static List<Turma> listAll() {
		return Dao.getInstance().list(hql(Turma.class, null, DEFAULT_ORDER));
	}

	public static Turma getComMesmoCodigoDesta(Turma turma) {
		return Dao.getInstance().uniqueResult(hql(Turma.class, ands(
												field("id").differentFrom(turma.getId()),
											    field("codigo").equalsTo(turma.getCodigo())
								)
			)
		);
	}

	public static Turma getComMesmoRepresentante(Turma turma) {
		return Dao.getInstance().uniqueResult(
				hql(Turma.class,
					ands(
							field("id").differentFrom(turma.getId()),
							field("representante").equalsTo(turma.getRepresentante())
					)
				)
		);
	}

	public static Turma getById(int id) {
		return Dao.getInstance().get(Turma.class,id);
	}

	public static long getTotalAlunosPara(Turma turma) {
		return Dao.getInstance().numRows(hql(Aluno.class, field("turma").equalsTo(turma)));
	}

	public static List<Turma> listBy(String busca) {
		return Dao.getInstance().list(hql(Turma.class, field("nome").matches(busca)));
	}

	public static List<Turma> listByWithFilter(String busca, TipoFiltroTurmaRepresentanteEnum tipoFiltro, TipoFiltroTurmaProfessorEnum tipoFiltroProfessor) {
		return Dao.getInstance().list(hql(Turma.class,
						ands(
								busca!=null? field("nome").matches(busca) : "",
								tipoFiltro!=null? tipoFiltro.getWhereHQL() : "",
								tipoFiltroProfessor!=null? tipoFiltroProfessor.getWhereHQL() : ""
						),
						DEFAULT_ORDER
				)
		);
	}

	public static List<Turma> listWithAluno() {
		return Dao.getInstance().list(hql(Turma.class,
						ands(
								field("alunos").isNotNull()
						),
						DEFAULT_ORDER
				)
		);
	}

	public static List<Turma> listByTurmaId(int professor) {
		return Dao.getInstance().list(hql(Turma.class, Is.selected(professor)? field("professor").equalsTo(professor) : "" ,DEFAULT_ORDER));
	}
}
