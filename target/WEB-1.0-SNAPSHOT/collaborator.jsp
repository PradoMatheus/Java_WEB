<%@ page import="br.com.fatec.web.domain.Collaborator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro de Colaboradores</title>
    <%@ include file="components/css_js.jsp" %>
</head>
<body>
<%@ include file="components/navbar.jsp" %>
<% Collaborator collaborator = new Collaborator();
    if (request.getAttribute("collaborator") != null) {
        collaborator = (Collaborator) request.getAttribute("collaborator");
    }%>
<form method="post" action="collaborator">
    <div class="container mt-5">
        <div class="fs-2 fw-bold text-center">
            Cadastro de Colaborador
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="txtCod">C&oacute;digo:</label>
            <div class="col-sm-1">
                <input type="text" class="form-control text-center" id="txtCod" name="txtCod"
                       value="<%if (collaborator.getId() > 0) out.print(collaborator.getId()); else out.print(0);%>"
                       readonly>
            </div>
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="txtName">Nome:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="txtName" name="txtName"
                       placeholder="Digite o nome do colaborador"
                       required="required"
                       value="<%if (collaborator.getId() > 0) out.print(collaborator.getName()); else out.print("");%>">
            </div>
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="txtJob">Cargo:</label>
            <div class="col-sm-10">
                <select class="form-select" id="txtJob" name="txtJob" required="required">
                    <option value="0" selected disabled>Selecione um Cargo</option>
                </select>
            </div>
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="txtEmail">E-mail:</label>
            <div class="col-sm-10">
                <input type="email" class="form-control" id="txtEmail" name="txtEmail" placeholder="seuemail@gmail.com"
                       required="required"
                       value="<%if (collaborator.getId() > 0) out.print(collaborator.getEmail()); else out.print("");%>">
            </div>
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="txtObs">Observa&ccedil;&atilde;o:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="txtObs" name="txtObs" rows="3" placeholder="..."
                       value="<%if (collaborator.getId() > 0) out.print(collaborator.getObservation()); else out.print("");%>"/>
            </div>
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="txtEnable">Ativo:</label>
            <div class="col-sm-10">
                <input type="checkbox" class="form-check-input" id="txtEnable" name="txtEnable"
                    <%if (collaborator.isActive() == true) out.print("checked"); else out.print("");%>>
            </div>
        </div>
        <%@ include file="components/buttons.jsp" %>
    </div>
    <script type="text/javascript">
        $(document).ready(function () {
            if (parseInt($("#txtCod").val()) > 0)
                $("#btn_delete").prop("disabled", false);

            $.get("role?operation=list&type=gson", function (value) {
                value.forEach(function (role) {
                    <%if(collaborator.getId() > 0){%>
                    if (role.id == <%out.print(collaborator.getRole().getId());%>)
                        $("#txtJob").append('<option value="' + role.id + '" selected>' + role.name + '</option>')
                    else
                        $("#txtJob").append('<option value="' + role.id + '">' + role.name + '</option>')
                    <%}else {%>
                    $("#txtJob").append('<option value="' + role.id + '">' + role.name + '</option>')
                    <%}%>
                })
            })
        })
    </script>
</form>
<%@ include file="components/complements_js.jsp" %>
</body>
</html>
