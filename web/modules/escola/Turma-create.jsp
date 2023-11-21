<%@taglib uri="futurepagesApp" prefix="fpg"%>
<%--@elvariable id="turma" type="modules.escola.beans.Turma"--%>

<script type="text/javascript">
    function goBack() {
        window.history.back();
    }
</script>

<style>
    /*Not Work*/
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
    /*Not Work*/
</style>

<div class="container">
    <h1 style="text-align: center;">Nova Turma</h1>
    <fpg:hasError>
        <div style="color: red; text-align: center; font-size: 20px">
            <fpg:error />
        </div>
    </fpg:hasError>

    <form method="post" action="<fpg:contextPath/>/escola/Turma-create" enctype="multipart/form-data">
        <div class="mainPlace">
            <div class="inputBasicPlace">
                <div class="form-group" style="text-align: center; padding: 10px; width: 50%">
                    <label for="nome">Nome</label>
                    <input class="form-control" id="nome" name="nome" value="${turma.nome}" />
                </div>
                <div class="form-group" style="text-align: center; padding: 10px; width: 50%">
                    <label for="codigo">Turma</label>
                    <input class="form-control" id="codigo" name="codigo" value="${turma.codigo}" />
                </div>
            </div>
            <div class="inputBasicPlace">
                <div class="inputBasicPlace" style="flex-direction: column; text-align: center; padding-inline: 8px; width: 45%">
                    <label for="tipo">Tipo</label>
                    <fpg:Select id="tipo" list="tipos" defaultText="Qual Tipo de Horario e a Turma" name="tipo" selected="${turma.tipo.id}" showAttr="nome" style="margin-top: 8px; margin-left: 5px; border: #206EA7 solid 2px; border-radius: 10px"/>
                </div>
                <div class="inputBasicPlace" style="flex-direction: column; text-align: center; padding-inline: 8px; width: 45%">
                    <label for="tipo">Professor</label>
                    <fpg:Select list="professores" name="professor" defaultText="Qual o Professor que será responsavel por está turma" defaultValue="0" selected="${turma.professor.id}" showAttr="nome" style="margin-top: 8px; margin-left: 5px; border: #206EA7 solid 2px; border-radius: 10px"/>
                </div>
            </div>
            <div class="inputBasicPlace" style="justify-content: space-between;">
                <button type="submit" class="btn btn-success" value="Salvar">Criar</button>
                <button class="btn btn-danger" type="button" onclick="goBack()">Cancelar</button>
            </div>
        </div>
    </form>
</div>