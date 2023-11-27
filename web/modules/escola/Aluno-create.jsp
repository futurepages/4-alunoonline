<%@taglib uri="futurepagesApp" prefix="fpg"%>
<%--@elvariable id="aluno" type="modules.escola.beans.Aluno"--%>

<%--Change to Java--%>
<script type="text/javascript">
    function goBack() {
        window.history.back()
    }
</script>

<style>
    .mainPlace{
        border: #206EA7 solid 4px;
        display: flex;
        flex-direction: column;
        justify-content: center;
        border-radius: 10px;
    }
    .inputBasicPlace{
        display: flex;
        padding: 10px;
        justify-content: center;
    }
</style>

<div class="container">
    <h1 style="text-align: center;">Novo Aluno</h1>
    <fpg:hasError>
        <div style="color: red; text-align: center; font-size: 20px">
            <fpg:error/>
        </div>
    </fpg:hasError>

    <form method="post" action="<fpg:contextPath/>/escola/Aluno-create" enctype="multipart/form-data">
        <div class="form-group mainPlace">
            <div class="inputBasicPlace">
                <div style="width: 50%; padding: 20px; text-align: center">
                    <label for="nome">Nome</label>
                    <input class="form-control" id="nome" name="nome" value="${aluno.nome}" />
                </div>
                <div style="width: 50%; padding: 20px; text-align: center">
                    <label for="matricula">Matrícula</label>
                    <input class="form-control" id="matricula" name="matricula" value="${aluno.matricula}" />
                </div>
            </div>
            <div class="inputBasicPlace">
                <div class="inputBasicPlace" style="flex-direction: column; text-align: center">
                    <label for="turma">Turma</label>
                    <fpg:Select id="turma"
                                list="turmas"
                                name="turma"
                                selected="${aluno.turma!=null?aluno.turma.id:0}"
                                showAttr="nome"
                                defaultText="Informe Qual Turma"
                                defaultValue=""
                                style="margin-top: 8px; margin-left: 5px; border: #206EA7 solid 2px; border-radius: 10px"
                    />
                </div>
            </div>
            <div class="inputBasicPlace">
                <div style="text-align: center">
                    <label for="foto">Foto 3x4</label>
                    <input style="width: 390px; border-style: none" class="form-control" type="file" id="foto" name="foto"/>
                </div>
            </div>
            <div class="inputBasicPlace" style="justify-content: space-between;">
                <button type="submit" class="btn btn-success" value="Salvar">Criar</button>
                <button class="btn btn-danger" type="button" onclick="goBack()">Cancelar</button>
            </div>
        </div>
    </form>
</div>
