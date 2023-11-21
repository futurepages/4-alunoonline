package modules.escola.validators;

import modules.escola.beans.Professor;
import modules.escola.dao.ProfessorDao;
import org.apache.commons.fileupload.FileItem;
import org.futurepages.menta.core.validation.Validator;
import org.futurepages.util.Is;

public class ProfessorValidator extends Validator {

	public void dataCreate(Professor professor, FileItem foto, String type) {
		String matricula = professor.getMatricula();

		if (Is.empty(professor.getNome_professor())){
			error("Preencha o nome do Professor.");
		}

		if (Is.empty(matricula)) { //verifica se matrícula vazia
			error("Especifique a matrícula do aluno.");
		} else {
			// Caso matrícula não seja vazia, verifica se a matrícula já existe
			if (ProfessorDao.getOutroComMatriculaDeste(matricula) != false) {
				error("Já existe um aluno ou um professor com esta matrícula.");
			}
		}

		if ((Is.empty(professor.getGraduacao()))){
			error("Informe a graduação do seu Ensino (Exemplo: Ensino Superior)");
		}

		if(foto==null){
			error("A foto 3x4 é obrigatória.");
		}else if(!foto.getContentType().equals("image/jpeg")) {
			error("A foto precisa ser JPG válida.");
		}

	}

	public void dataUpdate(Professor professor, FileItem foto, String type) {

	}
}
