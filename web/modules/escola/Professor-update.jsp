<%@taglib uri="futurepagesApp" prefix="fpg" %>
<%--@elvariable id="professor" type="modules.escola.beans.Professor"--%>

<div style="text-align: center;">
    <h2>Editar Professor</h2>
    <br/>
    <br/>
    <fpg:hasError>
        <!-- imprime estre pedaço somente se houver erro na página -->
        <div style="color: red; border:solid 1px red;">
            <fpg:error/>
        </div>
    </fpg:hasError>
    <br />
    <br />
    <a href="<fpg:contextPath />">Voltar ao início</a>
    <br />
    <br />
    <div >
        <form method="post" action="<fpg:contextPath/>/escola/Professor-update" enctype="multipart/form-data">
            <div style="display: inline-flex; padding: 10px">
                <div style="float: left; width: 500px">
                    <input name="id" value="${professor.id}" type="hidden"/>
                    Nome: <input id="nome_professor" class="input-nome" name="nome_professor" value="${professor.nome_professor}" />
                </div>
                <div style="float: right">
                    Matricula: <input id="matricula" name="matricula" value="${professor.matricula}" />
                </div>
                <div style="float: right">
                    Graduação: <input id="graduacao" name="graduacao" value="${professor.graduacao}" />
                </div>
            </div>
            <br>
            <div style="display: inline-flex; padding: 10px">
                <div style="padding-left: 5px">
                    Arquivo de Foto 3x4: <input type="file" name="foto"/>
                </div>
            </div>
            <br>
            <div style="display: inline-flex; padding: 10px">
                <fpg:Select name="turma" list="turmas" defaultValue="0" defaultText="Qual Turma vai ministrar?" showAttr="nome"/>
            </div>
            <br>
            <input type="submit" value="Atualizar" />
        </form>
    </div>
</div>

<style>
    .input-nome{
        width: 400px;
    }
</style>