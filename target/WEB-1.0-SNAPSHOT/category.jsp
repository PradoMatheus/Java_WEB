<%@ page import="br.com.fatec.web.domain.Category" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Cadastro de Categoria</title>
    <%@ include file="components/css_js.jsp" %>
</head>
<body>
<%@ include file="components/navbar.jsp" %>
<% Category category = new Category();
    if (request.getAttribute("category") != null) {
        category = (Category) request.getAttribute("category");
    }%>
<form method="post" action="category">
    <div class="container mt-5">
        <div class="fs-2 fw-bold text-center">
            Cadastro de Categoria
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="txtCod">C&oacute;digo:</label>
            <div class="col-sm-1">
                <input type="text" class="form-control text-center" id="txtCod" name="txtCod"
                       value="<%if (category.getId() > 0) out.print(category.getId()); else out.print(0);%>" readonly>
            </div>
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="txtName">Nome:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="txtName" name="txtName"
                       placeholder="Digite o nome da categoria"
                       required="required"
                       value="<%if (category.getId() > 0) out.print(category.getName()); else out.print("");%>">
            </div>
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="txtObs">Observa&ccedil;&atilde;o:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="txtObs" name="txtObs" rows="3" placeholder="..."
                       value="<%if (category.getId() > 0) out.print(category.getObservation()); else out.print("");%>"></input>
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
</body>
<%@ include file="components/complements_js.jsp" %>
</html>