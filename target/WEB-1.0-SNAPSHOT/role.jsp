<%@ page import="br.com.fatec.web.domain.Role" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro de Cargo</title>
    <%@ include file="components/css_js.jsp" %>
</head>
<body>
<%@ include file="components/navbar.jsp" %>
<% Role role = new Role();
    if (request.getAttribute("role") != null) {
        role = (Role) request.getAttribute("role");
    }%>
<form method="post" action="role">
    <div class="container mt-5">
        <div class="fs-2 fw-bold text-center">
            Cadastro de Cargo
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="txtCod">C&oacute;digo:</label>
            <div class="col-sm-1">
                <input type="text" class="form-control text-center" id="txtCod" name="txtCod"
                       value="<%if (role.getId() > 0) out.print(role.getId()); else out.print(0);%>" readonly>
            </div>
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="txtName">Nome:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="txtName" name="txtName"
                       value="<%if (role.getId() > 0) out.print(role.getName()); else out.print("");%>"
                       placeholder="Digite o nome da categoria" required>
            </div>
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="txtObs">Observa&ccedil;&atilde;o:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="txtObs" name="txtObs" rows="3"
                       value="<%if (role.getId() > 0) out.print(role.getObservation()); else out.print("");%>"
                       placeholder="..."></input>
            </div>
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="txtEnable">Ativo:</label>
            <div class="col-sm-10">
                <input type="checkbox" class="form-check-input" id="txtEnable" name="txtEnable" value=true
                    <%if (role.isActive() == true) out.print("checked"); else out.print("");%>>
            </div>
        </div>
        <%@ include file="components/buttons.jsp" %>
    </div>
</form>
<script type="text/javascript">
    $(document).ready(function () {
        if (parseInt($("#txtCod").val()) > 0)
            $("#btn_delete").prop("disabled", false);
    })
</script>
<%@ include file="components/complements_js.jsp" %>
</body>
</html>
