package modules.escola.install;

import install.Resources;
import org.futurepages.core.install.Installer;
import org.futurepages.enums.PathTypeEnum;

import java.io.File;

/*
 * Instala as turmas e depois os alunos.
 */
public class EscolaInstaller extends Installer{

    @Override
    public void execute() throws Exception {

	    File uploadsDirAlunos = new File(Resources.getUploadsPath(PathTypeEnum.REAL)+"/alunos");
	    File uploadsDirProfessores = new File(Resources.getUploadsPath(PathTypeEnum.REAL)+"/professores");

	    if(!uploadsDirAlunos.exists()){
		    uploadsDirAlunos.mkdirs();
	    }
		if(!uploadsDirProfessores.exists()){
			uploadsDirProfessores.mkdirs();
	    }

    }
}