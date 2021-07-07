<%@taglib uri="futurepagesApp" prefix="fpg" %>
<%--@elvariable id="turma" type="modules.escola.beans.Turma"--%>

<script type="text/javascript">
    function confirmaExclusao(id, nomeCompleto, matricula) {
        if(confirm("Deseja realmente apagar o aluno " + nomeCompleto + "\n(matricula: " + matricula + ")")) {
            document.location = '<fpg:contextPath/>/escola/Aluno-delete?id=' + id;
        }
    }
</script>

<div align="center">
	<h2>Listagem de Alunos</h2>
	<fpg:hasSuccess>
		<div style="text-align: center; width: 400px; color:green; border-color: green; background-color: greenyellow">
			<fpg:success/>
		</div>
		<br/>
		<br/>
	</fpg:hasSuccess>
	<a href="<fpg:contextPath/>/escola/Aluno?type=create">Novo Aluno</a>
	<br/>
	<br/>
    <form name="selecionaPorTurma" method="post" action="<fpg:contextPath/>/escola/Aluno-explore">
        <fpg:Select list="turmas" name="turma" selected="${turma}"
                    defaultText="- Todas as Turmas -" onchange="selecionaPorTurma.submit()"
                    showAttr="nome" />
    </form>
	<br/>
	<br/>
	<fpg:list value="alunos">
		<fpg:isEmpty>
		Nenhum aluno cadastrado.
		</fpg:isEmpty>
		<fpg:isEmpty negate="true">
			<table border="1">
				<tr>
					<td><strong>ID</strong></td>
					<td><strong>Foto</strong></td>
					<td><strong>Nome</strong></td>
					<td><strong>Matrícula</strong></td>
                    <td><strong>Turma</strong></td>
                    <td colspan="2" style="text-align: center;"><strong>Ações</strong></td>
				</tr>
				<fpg:loop var="aluno">
					<fpg:aluno aluno="${aluno}" green="${aluno.turma!=null}"/>
				</fpg:loop>
			</table>
		</fpg:isEmpty>
	</fpg:list>
	<br/>
	<br/>
</div>
