<%@ page import="br.com.fatec.web.domain.Collaborator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro de Colaboradores</title>
    <%@ include file="components/css_js.jsp" %>
</head>
<body>
<%@ include file="components/navbar.jsp" %>
<% if (request.getAttribute("collaborator") != null) {
    Collaborator collaborator = (Collaborator) request.getAttribute("collaborator");
}%>
<form method="post" action="collaborator">
    <div class="container mt-5">
        <div class="fs-2 fw-bold text-center">
            Cadastro de Colaborador
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="txtCod">C&oacute;digo:</label>
            <div class="col-sm-1">
                <input type="text" class="form-control text-center" id="txtCod" name="txtCod" value="0" readonly>
            </div>
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="txtName">Nome:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="txtName" name="txtName"
                       placeholder="Digite o nome do colaborador"
                       required="required">
            </div>
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="txtJob">Cargo:</label>
            <div class="col-sm-10">
                <select class="form-select" id="txtJob" name="txtJob" required="required">
                    <option value="0" selected disabled>Selecione um Cargo</option>
                    <option value="1">Gerente</option>
                    <option value="2">Analista</option>
                </select>
            </div>
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="txtEmail">E-mail:</label>
            <div class="col-sm-10">
                <input type="email" class="form-control" id="txtEmail" name="txtEmail" placeholder="seuemail@gmail.com"
                       required="required">
            </div>
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="txtObs">Observa&ccedil;&atilde;o:</label>
            <div class="col-sm-10">
                <textarea class="form-control" id="txtObs" name="txtObs" rows="3" placeholder="..."></textarea>
            </div>
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="txtEnable">Ativo:</label>
            <div class="col-sm-10">
                <input type="checkbox" class="form-check-input" id="txtEnable" name="txtEnable">
            </div>
        </div>
        <%@ include file="components/buttons.jsp" %>
    </div>
</form>
<%@ include file="components/complements_js.jsp" %>
</body>
</html>
