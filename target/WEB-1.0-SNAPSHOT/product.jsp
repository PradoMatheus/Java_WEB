<%@ page import="br.com.fatec.web.domain.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Cadastros de Produto</title>
    <%@ include file="components/css_js.jsp" %>
</head>
<body>
<%@ include file="components/navbar.jsp" %>
<%
    Product product = new Product();
    if (request.getAttribute("product") != null) {
        product = (Product) request.getAttribute("product");
    }
%>
<form method="post" action="product">
    <div class="container mt-5">
        <div class="fs-2 fw-bold text-center">
            Cadastro de Produto
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="txtCod">C&oacute;digo:</label>
            <div class="col-sm-1">
                <input type="text" class="form-control text-center" id="txtCod" name="txtCod"
                       value="<%if (product.getId() > 0) out.print(product.getId()); else out.print(0);%>" readonly>
            </div>
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="txtName">Nome:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="txtName" name="txtName"
                       value="<%if (product.getId() > 0) out.print(product.getName()); else out.print("");%>"
                       placeholder="Digite o nome do produto" required>
            </div>
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="txtDescription">Descri&ccedil;&atilde;o:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="txtDescription" name="txtDescription" rows="3"
                       placeholder="..."
                       value="<%if (product.getId() > 0) out.print(product.getDescription()); else out.print("");%>"
                       required/>
            </div>
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="txtEAN">EAN:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="txtEAN" name="txtEAN"
                       value="<%if (product.getId() > 0) out.print(product.getEan()); else out.print("");%>" required>
            </div>
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="txtCategory">Categoria:</label>
            <div class="col-sm-10">
                <select class="form-select" id="txtCategory" name="txtCategory" required>
                    <option value="0"
                            selected
                            disabled>Selecione uma categoria
                    </option>
                </select>
            </div>
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="txtValue">Valor Unitario:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="txtValue" name="txtValue"
                       value="<%if (product.getId() > 0) out.print(product.getValue()); else out.print(0);%>"
                       required>
            </div>
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="txtEnable">Ativo:</label>
            <div class="col-sm-10">
                <input type="checkbox" class="form-check-input" id="txtEnable" name="txtEnable" value=true
                    <%if (product.isActive() == true) out.print("checked"); else out.print("");%>>
            </div>
        </div>
        <%@ include file="components/buttons.jsp" %>
    </div>
    <script type="text/javascript">
        $(document).ready(function (event) {
            $("#txtEnable").on("change", function (){
                if (this.checked)
                    console.log(true)
                else
                    console.log(false)
            })
            if (parseInt($("#txtCod").val()) > 0)
                $("#btn_delete").prop("disabled", false);

            $.get("category?operation=list&type=gson", function (value) {
                value.forEach(function (category) {
                    $("#txtCategory").append('<option value="' + category.id + '">' + category.name + '</option>')
                })
            })

            $.get("category?operation=list&type=gson", function (value) {
                value.forEach(function (category) {
                    <%if(product.getId() > 0){%>
                    if (category.id == <%out.print(product.getCategory().getId());%>)
                        $("#txtCategory").append('<option value="' + category.id + '" selected>' + category.name + '</option>')
                    else
                        $("#txtCategory").append('<option value="' + category.id + '">' + category.name + '</option>')
                    <%}else {%>
                    $("#txtCategory").append('<option value="' + category.id + '">' + category.name + '</option>')
                    <%}%>
                })
            })
        })
    </script>
</form>
</script>
<%@ include file="components/complements_js.jsp" %>
<script src="js/product.js"></script>
</body>
</html>