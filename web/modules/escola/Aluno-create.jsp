<%@taglib uri="futurepagesApp" prefix="fpg"%>
<%--@elvariable id="aluno" type="modules.escola.beans.Aluno"--%>

<div class="container">
    <h1 style="text-align: center;">Novo Aluno</h1>
    <br/>
    <br/>
    <fpg:hasError>
        <div style="color: red; border:solid 1px red">
            <fpg:error/>
        </div>
    </fpg:hasError>
        <br/>

    <form method="post" action="<fpg:contextPath/>/escola/Aluno-create" enctype="multipart/form-data">
        <div class="form-group">
            <label for="nomeCompleto">Nome</label>
            <input class="form-control" id="nomeCompleto" name="nomeCompleto" value="${aluno.nomeCompleto}" />
        </div>
        <div class="form-group">
            <label for="matricula">Matrícula</label>
            <input class="form-control" id="matricula" name="matricula" value="${aluno.matricula}" />
        </div>
        <div class="form-group">
            <label for="turma">Turma</label>
            <fpg:Select id="turma"
                        list="turmas"
                        name="turma"
                        selected="${aluno.turma!=null?aluno.turma.id:0}"
                        showAttr="nome"
                        defaultText="- Sem turma -"
                        defaultValue=""
            />
        </div>
        <div class="form-group">
            <label for="foto">Foto 3x4</label>
            <input class="form-control" type="file" id="foto" name="foto"/>
        </div>
        <button type="submit" class="btn btn-primary" value="Salvar"> Salvar </button>
    </form>
</div>
