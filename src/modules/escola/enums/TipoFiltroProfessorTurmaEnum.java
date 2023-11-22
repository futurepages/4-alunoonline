package modules.escola.enums;

import static org.futurepages.core.persistence.HQLProvider.*;

public enum TipoFiltroProfessorTurmaEnum {
	PROFESSORES_COM_TURMA ("Profesores com turma", size("p.turmasResponsaveis").greaterEqualsThen(1)),
	PROFESSORES_SEM_TURMA ("Profesores sem turma",  size("p.turmasResponsaveis").equalsTo(0));
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
