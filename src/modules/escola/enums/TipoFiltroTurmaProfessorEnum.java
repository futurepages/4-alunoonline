package modules.escola.enums;

import static org.futurepages.core.persistence.HQLProvider.field;

public enum TipoFiltroTurmaProfessorEnum {
	TURMA_SEM_PROFESSOR("Turma sem professor", field("professor").isNull()),
	TURMA_COM_PROFESSOR("Turma com professor", field("professor").isNotNull());
	private final String rotulo;
	private final String whereHQL;

	TipoFiltroTurmaProfessorEnum(String rotulo, String whereHQL) {
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
