<%@ page import="br.com.fatec.web.domain.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Cadastros de Produto</title>
    <%@ include file="components/css_js.jsp" %>
</head>
<body>
<%@ include file="components/navbar.jsp" %>
<% if (request.getAttribute("product") != null) {
    Product product = (Product) request.getAttribute("product");
}%>
<form method="post" action="product">
    <div class="container mt-5">
        <div class="fs-2 fw-bold text-center">
            Cadastro de Produto
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
                       placeholder="Digite o nome do produto" required>
            </div>
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="txtDescription">Descri&ccedil;&atilde;o:</label>
            <div class="col-sm-10">
                <textarea class="form-control" id="txtDescription" name="txtDescription" rows="3" placeholder="..."
                          required></textarea>
            </div>
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="txtEAN">EAN:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="txtEAN" name="txtEAN" required>
            </div>
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="txtCategory">Categoria:</label>
            <div class="col-sm-10">
                <select class="form-select" id="txtCategory" name="txtCategory" required>
                    <option value="0" selected disabled>Selecione uma categoria</option>
                    <option value="1">Categoria 1</option>
                    <option value="2">Categoria 2</option>
                </select>
            </div>
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="txtValue">Valor Unitario:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="txtValue" name="txtValue" required>
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
<script src="js/product.js"></script>
</body>
</html>