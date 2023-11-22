<%@tag pageEncoding="UTF-8" %>
<%@taglib uri="futurepagesApp" prefix="fpg"%>
<%--@elvariable id="params" type="java.util.Map"--%>
<%--@elvariable id="turma" type="modules.escola.beans.Turma"--%>

<%@attribute name="professor" type="modules.escola.beans.Professor"  required="true"%>

<style>
    .excluir:hover{
        fill: #ff0000;
    }
    .modificar:hover {
        fill: #ffe00e
    }
    .inputBasicPlace{
        display: flex;
        padding: 10px;
        justify-content: center;
    }
</style>

<tr>
	<td style="text-align: center"><img src="${params.UPLOADS_URL_PATH}/professores/${professor.id}.jpg" style="width: 52px;"/></td>
	<td>${professor.nome}</td>
	<td>${professor.matricula}</td>
	<td>${professor.graduacao}</td>
	<td>
		<fpg:list value="professor.turmasResponsaveis">
			<fpg:loop var="turma">
				${turma.nome},
			</fpg:loop>
		</fpg:list>
	</td>
	<td>
		<div style="display: flex; padding: 10px; justify-content: center;">
			<a class="modificar" href="<fpg:contextPath/>/escola/Professor?type=update&id=${professor.id}" style="margin-inline: 5px;">
				<svg class="modificar" style="fill: #000000" onMouseOver="this.style.fill='#ffe00e'" onmouseout="this.style.fill='#000000'" xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 512 512"><!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><path d="M362.7 19.3L314.3 67.7 444.3 197.7l48.4-48.4c25-25 25-65.5 0-90.5L453.3 19.3c-25-25-65.5-25-90.5 0zm-71 71L58.6 323.5c-10.4 10.4-18 23.3-22.2 37.4L1 481.2C-1.5 489.7 .8 498.8 7 505s15.3 8.5 23.7 6.1l120.3-35.4c14.1-4.2 27-11.8 37.4-22.2L421.7 220.3 291.7 90.3z"/></svg>
			</a>
			<a class="excluir" href="javascript:confirmaExclusao('${professor.id}', '${professor.nome}', '${professor.matricula}');" style="margin-inline: 5px;">
				<svg class="excluir" style="fill: #000000" onmouseover="this.style.fill='#ff0000'" onmouseout="this.style.fill='#000000'" xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 384 512"><!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><path d="M376.6 84.5c11.3-13.6 9.5-33.8-4.1-45.1s-33.8-9.5-45.1 4.1L192 206 56.6 43.5C45.3 29.9 25.1 28.1 11.5 39.4S-3.9 70.9 7.4 84.5L150.3 256 7.4 427.5c-11.3 13.6-9.5 33.8 4.1 45.1s33.8 9.5 45.1-4.1L192 306 327.4 468.5c11.3 13.6 31.5 15.4 45.1 4.1s15.4-31.5 4.1-45.1L233.7 256 376.6 84.5z"/></svg>
			</a>
		</div>
	</td>
</tr>