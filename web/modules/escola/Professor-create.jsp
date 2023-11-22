<%@taglib uri="futurepagesApp" prefix="fpg"%>
<%--@elvariable id="professor" type="modules.escola.beans.Professor"--%>
<%--@elvariable id="turma" type="modules.escola.beans.Turma"--%>

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
    <h1 style="text-align: center;">Novo Professor</h1>

    <fpg:hasError>
        <div style="color: red; text-align: center; font-size: 20px">
            <fpg:error />
        </div>
    </fpg:hasError>

    <form method="post" action="<fpg:contextPath/>/escola/Professor-create" enctype="multipart/form-data">
        <div class="mainPlace form-group">
            <div class="inputBasicPlace">
                <div style="width: 50%; padding: 20px; text-align: center">
                    <label for="nome">Nome</label>
                    <input class="form-control" id="nome" name="nome" value="${professor.nome}" placeholder="Insira seu Nome"/>
                </div>
                <div style="width: 50%; padding: 20px; text-align: center">
                    <label for="matricula">Matrícula</label>
                    <input class="form-control" id="matricula" name="matricula" value="${professor.matricula}" placeholder="00N0000000"/>
                </div>
                <div style="width: 50%; padding: 20px; text-align: center">
                    <label for="graduacao">Graduação</label>
                    <input class="form-control" id="graduacao" name="graduacao" value="${professor.graduacao}" placeholder="Seu nível de escolaridade"/>
                </div>
            </div>
            <div class="inputBasicPlace">
                <div class="inputBasicPlace" style="flex-direction: column; text-align: center">
                    <label for="turma">Turma</label>
                    <fpg:Select id="turma"
                                list="turmas"
                                name="turma"
                                selected="${turma.id}"
                                showAttr="nome"
                                defaultText="Informe Qual Turma"
                                defaultValue="0"
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
            <div class="inputBasicPlace" style="justify-content: space-between; padding-inline: 30px">
                <button type="submit" class="btn btn-success" value="Salvar">Criar</button>
                <button class="btn btn-danger" type="button" onclick="goBack()">Cancelar</button>
            </div>
        </div>
    </form>
</div>
