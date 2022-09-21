package modules.escola.actions;

import install.Resources;
import modules.escola.beans.Professor;
import modules.escola.beans.Turma;
import modules.escola.dao.ProfessorDao;
import modules.escola.dao.TurmaDao;
import modules.escola.enums.TipoFiltroProfessorTurmaEnum;
import modules.escola.validators.ProfessorValidator;
import org.apache.commons.fileupload.FileItem;
import org.futurepages.core.persistence.Dao;
import org.futurepages.core.persistence.annotations.Transactional;
import org.futurepages.enums.PathTypeEnum;
import org.futurepages.menta.actions.CrudActions;
import org.futurepages.util.The;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ProfessorActions extends CrudActions {

    /*
     * É função executada ao chamar-se Professor-create.jsp
     */
    @Transactional
    public String create() throws Exception {
        Professor professor = (Professor) input.getValue("professor");
        FileItem foto = (FileItem) input.getValue("foto");
        validate(ProfessorValidator.class).createOrUpdate(professor, foto);
        Dao.getInstance().save(professor);
        gravaFoto(professor,foto);
        return success("Professor criado com sucesso");
    }


    /*
     * listObjects() é a filtragem padrão da listagem.
     * É o filtro default da listagem. Entenda quando é chamado em CrudActions.execute()
     * É quando executado quando chama-se Professor.jsp?type=explore
     */
    @Override
    protected void listObjects() {
        explore(null);
    }

    /*
     * É a execução da filtragem.
     *
     * É executado quando chamamos Professor-explore.jsp
     */
    public String explore(String tipoFiltroName) {
        TipoFiltroProfessorTurmaEnum tipoFiltro = null;
        try {
            tipoFiltro = TipoFiltroProfessorTurmaEnum.valueOf(tipoFiltroName);
        }catch (Exception ignored){}

//        Turma turma = Is.selected(turmaId)? Dao.getInstance().get(Turma.class, turmaId) : null;
//
//        List<Aluno> alunos = AlunoDao.listByTurmaIdAndTipoFiltro(turma, tipoFiltro);
//
//        List<Turma> turmas = TurmaDao.listAll();
        TipoFiltroProfessorTurmaEnum[] opcoesFiltroTurma = TipoFiltroProfessorTurmaEnum.values();

        // lista principal...
        output("professores", ProfessoresFiltrados(tipoFiltro));

//        // dependencias de filtragem
//      output("turmas", turmas);
        output("opcoesFiltroTurma", opcoesFiltroTurma);
//
//        //filtros selecionados
//      output("turma", turma); //turma filtrada
        output("tipoFiltro", tipoFiltro); //filtro tipo turma realizado
        return SUCCESS;
    }

    @SuppressWarnings("PointlessBooleanExpression")
    public List<Professor> ProfessoresFiltrados(TipoFiltroProfessorTurmaEnum filtro){
        List<Professor> professoresFiltrados = new ArrayList<>();
        if(filtro == TipoFiltroProfessorTurmaEnum.PROFESSOR_COM_TURMA){
            for (Professor professor: ProfessorDao.listAll()) {
                if(professor.getTurmas().isEmpty() == false){
                    professoresFiltrados.add(professor);
                }
            }
            return professoresFiltrados;
        }

        if(filtro == TipoFiltroProfessorTurmaEnum.PROFESSOR_SEM_TURMA){
            for (Professor professor: ProfessorDao.listAll()) {
                if(professor.getTurmas().isEmpty() == true){
                    professoresFiltrados.add(professor);
                }
            }
            return professoresFiltrados;
        }
        return ProfessorDao.listAll();
    }


    /*
     * Ação de atualização do professor no arquivo  Professor-create.jsp
     */
    @Transactional
    public String update() throws Exception {
        Professor professor = (Professor) input.getValue("professor");
        FileItem foto = (FileItem) input.getValue("foto");
        validate(ProfessorValidator.class).createOrUpdate(professor, foto);
        Professor professorDB = ProfessorDao.getById(professor.getId());
        professorDB.fillFromUpdateForm(professor);
        Dao.getInstance().updateTransaction(professorDB);

        gravaFoto(professor,foto);
        return success("Professor atualizado com sucesso");
    }

    /*
     * Chamado ao confirmar exclusão do professor
     * OBS: Antes de deletar o professor, remove a referência deste nas turmas
     */
    @Transactional
    public String delete() {
        Professor professor = (Professor) input.getValue("professor");
        for (Turma turma: TurmaDao.listAll()) {
            if(turma.getProfessor() == null){
                continue;
            }
            if(turma.getProfessor().getId() == professor.getId()){
                turma.RemoverProfessor();
                Dao.getInstance().updateTransaction(turma);
            }
        }
        professor = ProfessorDao.getById(professor.getId());
        Dao.getInstance().delete(professor);
        return success("Professor excluído com sucesso.");
    }

    /*
     * método chamado ao editar um professor. Ele coloca os dados do professor selecionado
     * nos devidos inputs
     */
    @Override
    protected void restoreObject() {
        Professor professor = (Professor) input.getValue("professor");

        professor = ProfessorDao.getById(professor.getId());
        output("professor", professor);
    }

    private void gravaFoto(Professor professor, FileItem foto) throws Exception {
        if(foto == null) return;
        String uploadsPath = Resources.getUploadsPath(PathTypeEnum.REAL);
        String path = The.concat(uploadsPath, "/professores/", String.valueOf(professor.getId()),".jpg");
        File file = new File(path);
        foto.write(file);
    }

    /*
     * Metodo usado para retornar as dependencias necessarias tanto na criação quanto na atualização
     * do professor
     */
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
