<%@taglib uri="futurepagesApp" prefix="fpg"%>
<%--@elvariable id="professor" type="modules.escola.beans.Professor"--%>
<%--@elvariable id="turma" type="modules.escola.beans.Turma"--%>
<%--@elvariable id="tipoFiltro" type="modules.escola.enums.TipoFiltroProfessorTurmaEnum"--%>

<script type="text/javascript">
    function confirmaExclusao(id, nome, matricula) {
        if(confirm("Deseja realmente apagar o Professor " + nome + "\n(matricula: " + matricula + ")")) {
            document.location = '<fpg:contextPath/>/escola/Professor-delete?id=' + id;
        }
    }
</script>

<div align="center">
	<h2>Listagem de Professores</h2>
	<fpg:hasSuccess>
		<div style="text-align: center; width: 400px; color:green; border-color: green; background-color: greenyellow">
			<fpg:success/>
		</div>
		<br/>
		<br/>
	</fpg:hasSuccess>
	<a href="<fpg:contextPath/>/escola/Professor?type=create">Adicionar Professor</a>
	<br/>
	<br/>
		<div style="margin-left: 80px; margin-right: 80px">
			<form id="form-filtro-professor" method="get" action="<fpg:contextPath/>/escola/Professor-explore">
				<div class="inputBasicPlace">
					<div class="inputBasicPlace" style="flex-direction: column; width: 40%;">
					</div>
				</div>
				<fpg:Select list="turmas"
				            name="turmaId"
				            selected="${turma!=null? turma.id : 0}"
				            defaultText="Qual Turma Deseja Procurar"
				            onchange="$('#form-filtro-professor').submit()"
				            showAttr="nome"
				/>

				<fpg:Select list="opcoesFiltroProfessor"
				            showAttr="rotulo"
				            name="tipoFiltroName"
				            selected="${tipoFiltro!=null? tipoFiltro.name() : ''}"
				            idName="id"
				            defaultValue=""
				            onchange="$('#form-filtro-professor').submit()"
				            defaultText="Possui Turma?"
				/>
			</form>

			<table class="table table-bordered table-striped"
			       id="table"
			       data-toggle="table"
			       style="text-align: center;">
				<tr>
					<td><strong>Foto</strong></td>
					<td data-field="codigo"><strong>Nome</strong></td>
					<td data-field="codigo"><strong>Matrícula</strong></td>
					<td data-field="codigo"><strong>Graduçao</strong></td>
					<td data-field="codigo"><strong>Turma(s) Responsável(is)</strong></td>
					<td colspan="2" style="text-align: center;"><strong>Ações</strong></td>
				</tr>
				<fpg:list value="professores">
					<fpg:loop var="professor">
						<fpg:isEmpty>
							Nenhum Professor cadastrado.
						</fpg:isEmpty>
						<fpg:isEmpty negate="true">
							<fpg:professor professor="${professor}"/>
						</fpg:isEmpty>
					</fpg:loop>
				</fpg:list>
			</table>
		</div>
	<br/>
	<br/>
</div>