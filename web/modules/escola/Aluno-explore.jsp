<%@taglib uri="futurepagesApp" prefix="fpg" %>
<%--@elvariable id="turma" type="modules.escola.beans.Turma"--%>
<%--@elvariable id="tipoFiltro" type="modules.escola.enums.TipoFiltroAlunoTurmaEnum"--%>

<script type="text/javascript">
    function confirmaExclusao(id, nomeCompleto, matricula) {
        if(confirm("Deseja realmente apagar o aluno " + nomeCompleto + "\n(matricula: " + matricula + ")")) {
            document.location = '<fpg:contextPath/>/escola/Aluno-delete?id=' + id;
        }
    }
</script>

<style>
    td {
	    border: #000000 solid 2px;
    }
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

<div align="center">
	<h2>Listagem de Alunos</h2>
	<fpg:hasSuccess>
	<div style="text-align: center; color:green;">
		<fpg:success/>
	</div>
	</fpg:hasSuccess>
	<a href="<fpg:contextPath/>/escola/Aluno?type=create">Adicionar Aluno</a>
	<form id="form-filtro-alunos" method="get" action="<fpg:contextPath/>/escola/Aluno-explore">
		<div class="inputBasicPlace">
			<div class="inputBasicPlace" style="flex-direction: column; width: 40%;">
				<label style="text-align: center">Filtar por turma existente</label>
				<fpg:Select list="turmas"
				            name="turmaId"
				            selected="${turma!=null? turma.id : 0}"
				            defaultText="Qual Turma"
				            onchange="$('#form-filtro-alunos').submit()"
				            showAttr="nome"
				            style="text-align: center; margin-left: 5px; border: #206EA7 solid 2px; border-radius: 10px"
				/>
			</div>
			<div class="inputBasicPlace" style="flex-direction: column; width: 40%;">
				<label style="text-align: center">Filtar por que estão ou não em uma Turma</label>
				<fpg:Select list="opcoesFiltroTurma"
				            showAttr="rotulo"
				            name="tipoFiltroName"
				            selected="${tipoFiltro!=null? tipoFiltro.name() : ''}"
				            idName="id"
				            defaultValue=""
				            onchange="$('#form-filtro-alunos').submit()"
				            defaultText="Possui ou Não Turma"
				            style="text-align: center; margin-left: 5px; border: #206EA7 solid 2px; border-radius: 10px"
				/>
			</div>
		</div>
	</form>
	<fpg:list value="alunos">
		<fpg:isEmpty>
			Nenhum aluno cadastrado.
		</fpg:isEmpty>
		<fpg:isEmpty negate="true">
			<div style="margin-left: 80px; margin-right: 80px">
				<table class="table table-bordered table-striped"
				       id="table"
				       style="text-align: center; border: #000000 solid 2px; border-radius: 10px">
					<tr style="background-color: #0808b7; color: #ffffff">
							<%--						<td data-field="id"><strong>ID</strong></td>--%>
						<td><strong>Foto</strong></td>
						<td data-field="codigo"><strong>Nome</strong></td>
						<td data-field="codigo"><strong>Matrícula</strong></td>
						<td style="text-align: center;"><strong>Ações</strong></td>
						<td data-field="codigo"><strong>Turma</strong></td>
					</tr>
					<fpg:loop var="aluno">
						<fpg:aluno aluno="${aluno}" green="${aluno.turma!=null}"/>
					</fpg:loop>
				</table>
			</div>
		</fpg:isEmpty>
	</fpg:list>
</div>