<%--@elvariable id="mensagemInicial" type="java.lang.String"--%>
<%--@elvariable id="momentoAtual" type="java.lang.String"--%>
<%--@elvariable id="resumo" type="java.lang.String"--%>

<%@taglib uri="futurepagesApp" prefix="fpg"%>

<style>
    .options{
        padding: 10px;
    }
    a:link {
        color: #ffffff;
        background-color: transparent;
        text-decoration: none;
    }

    a:visited {
        color: #ffffff;
        background-color: transparent;
        text-decoration: none;
    }

    a:hover {
        color: #ffffff;
        background-color: transparent;
        text-decoration: none;
    }

    a:active {
        color: #ffffff;
        background-color: transparent;
        text-decoration: none;
    }

    .mainContainer{
        background-color: #206EA7;
        border-radius: 20px;
        display: flex;
        justify-content: space-between;
        align-content: center;
        color: #ffffff;
        padding-inline: 15px;
    }

    svg:hover + .mainContainer{
        background-color: #23cb00;
    }
</style>

<div style="text-align:center">
    <h1>${mensagemInicial}</h1>
    <%--	<h2>--%>
    <%--	    <fpg:valueFormatter object="${momentoAtual}" formatter="fullDateLiteral"/>--%>
    <%--	</h2>--%>
    <h4>${resumo}</h4>
    <div style="margin: 5px; padding-bottom: 10px; padding-top: 10px; width: 100%; height: 10px; font-size: 24px">
        <div class="options">
            <div class="mainContainer">
                <a href="<fpg:contextPath/>/escola/Aluno?type=explore">Listar Alunos</a>
                <a href="<fpg:contextPath/>/escola/Aluno?type=create" class="create">
                    <svg class="create" xmlns="http://www.w3.org/2000/svg" height="1.8em" viewBox="0 0 448 512"><!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><style>svg{fill:#ffffff}</style><path d="M256 80c0-17.7-14.3-32-32-32s-32 14.3-32 32V224H48c-17.7 0-32 14.3-32 32s14.3 32 32 32H192V432c0 17.7 14.3 32 32 32s32-14.3 32-32V288H400c17.7 0 32-14.3 32-32s-14.3-32-32-32H256V80z"/>></svg>
                </a>
            </div>
        </div>
        <div class="options">
            <div class="mainContainer">
                <a href="<fpg:contextPath/>/escola/Turma?type=explore" >Listar Turmas</a>
                <a href="<fpg:contextPath/>/escola/Turma?type=create" class="create">
                    <svg class="create" xmlns="http://www.w3.org/2000/svg" height="1.8em" viewBox="0 0 448 512"><!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><style>svg{fill:#ffffff}</style><path d="M256 80c0-17.7-14.3-32-32-32s-32 14.3-32 32V224H48c-17.7 0-32 14.3-32 32s14.3 32 32 32H192V432c0 17.7 14.3 32 32 32s32-14.3 32-32V288H400c17.7 0 32-14.3 32-32s-14.3-32-32-32H256V80z"/></svg>
                </a>
            </div>
        </div>
        <div class="options">
            <div class="mainContainer">
                <a href="<fpg:contextPath/>/escola/Professor?type=explore" >Listar Professores</a>
                <a href="<fpg:contextPath/>/escola/Professor?type=create" class="create">
                    <svg class="create" xmlns="http://www.w3.org/2000/svg" height="1.8em" viewBox="0 0 448 512"><!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><style>svg{fill:#ffffff}</style><path d="M256 80c0-17.7-14.3-32-32-32s-32 14.3-32 32V224H48c-17.7 0-32 14.3-32 32s14.3 32 32 32H192V432c0 17.7 14.3 32 32 32s32-14.3 32-32V288H400c17.7 0 32-14.3 32-32s-14.3-32-32-32H256V80z"/>></svg>
                </a>
            </div>
        </div>
    </div>
</div>