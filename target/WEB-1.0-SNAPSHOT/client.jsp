<%@ page import="br.com.fatec.web.domain.Client" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro de Clientes</title>
    <%@ include file="components/css_js.jsp" %>
</head>
<body>
<%@ include file="components/navbar.jsp" %>
<% if (request.getAttribute("client") != null) {
    Client client = (Client) request.getAttribute("client");
}%>
<form method="get" action="client">
    <div class="container mt-5">
        <div class="fs-2 fw-bold text-center">
            Cadastro de Cliente
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
                       placeholder="Digite o nome do cliente" required="required">
            </div>
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="txtCPF">CPF:</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="txtCPF" name="txtCPF" placeholder="XXX.XXX.XXX-XX"
                       required="required">
            </div>
            <label class="col-sm-1 col-form-label" for="txtEmail">E-mail:</label>
            <div class="col-sm-5">
                <input type="email" class="form-control" id="txtEmail" name="txtEmail" placeholder="seuemail@gmail.com"
                       required="required">
            </div>
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="txtPhone">Telefone:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="txtPhone" name="txtPhone" placeholder="(XX) XXXXX-XXXX"
                       required="required">
            </div>
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="txtZIP">CEP:</label>
            <div class="col-sm-2">
                <input type="text" class="form-control" id="txtZIP" name="txtZIP" placeholder="XXXXX-XXX"
                       required="required">
            </div>
            <div class="col-sm-2">
                <button type="button" class="btn btn-primary" id="btnSearchZIP"><i class="fa fa-search"></i> Buscar
                </button>
            </div>
            <label class="col-sm-1 col-form-label" for="txtCity">Cidade:</label>
            <div class="col-sm-2">
                <input type="text" class="form-control" id="txtCity" name="txtCity" required="required">
            </div>
            <label class="col-sm-1 col-form-label" for="txtNeighborhood">Bairro:</label>
            <div class="col-sm-2">
                <input type="text" class="form-control" id="txtNeighborhood" name="txtNeighborhood" required="required">
            </div>
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="txtAddress">Endereço:</label>
            <div class="col-sm-7">
                <input type="text" class="form-control" id="txtAddress" name="txtAddress" placeholder="Endereço"
                       required="required">
            </div>
            <label class="col-sm-1 col-form-label" for="txtNumber">Nª:</label>
            <div class="col-sm-2">
                <input type="text" class="form-control" id="txtNumber" name="txtNumber" placeholder="Número"
                       required="required">
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
<script src="js/client.js"></script>
</body>
</html>
