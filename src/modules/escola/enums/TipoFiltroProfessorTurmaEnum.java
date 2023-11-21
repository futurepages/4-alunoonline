package modules.escola.enums;

import static org.futurepages.core.persistence.HQLProvider.field;

public enum TipoFiltroProfessorTurmaEnum {
	PROFESSORES_COM_TURMA ("Profesores com turma", field("t.professor").isNotNull()),
	PROFESSORES_SEM_TURMA ("Profesores sem turma", field("t.professor").isNull());

	private final String rotulo;
	private final String whereHQL;

	TipoFiltroProfessorTurmaEnum(String rotulo, String whereHQL) {
		this.rotulo = rotulo;
		this.whereHQL = whereHQL;
	}

	public String getRotulo() {
		return rotulo;
	}

	public String getWhereHQL() {
		return whereHQL;
	}

	public String getId(){
		return name();
	}

}
