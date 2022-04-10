<%@ page import="br.com.fatec.web.domain.Order" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Cadastros de Produto</title>
    <%@ include file="components/css_js.jsp" %>
</head>
<body>
<%@ include file="components/navbar.jsp" %>
<% if (request.getAttribute("order") != null) {
    Order order = (Order) request.getAttribute("order");
}%>
<form method="post" action="order">
    <div class="container mt-5">
        <div class="fs-2 fw-bold text-center">
            Cadastro de Pedido
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="txtCod">C&oacute;digo:</label>
            <div class="col-sm-1">
                <input type="text" class="form-control text-center" id="txtCod" name="txtCod" value="0" readonly>
            </div>
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="selClient">Cliente:</label>
            <div class="col-sm-10">
                <select class="form-select" id="selClient" name="selClient" required>
                    <option value="0" selected disabled>Selecione um cliente</option>
                    <option value="1">Maria</option>
                    <option value="2">Pedro</option>
                </select>
            </div>
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="selVendor">Vendedor:</label>
            <div class="col-sm-10">
                <select class="form-select" id="selVendor" name="selVendor" required>
                    <option value="0" selected disabled>Selecione um vendedor</option>
                    <option value="1">Ana</option>
                    <option value="2">Jonas</option>
                </select>
            </div>
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="selProduct">Produto:</label>
            <div class="col-sm-5">
                <select class="form-select" id="selProduct" name="selProduct" required>
                    <option value="0" selected disabled>Selecione um produto</option>
                    <option value="1">Caneta</option>
                    <option value="2">Caderno</option>
                </select>
            </div>
            <label class="col-sm-1 col-form-label" for="txtPrice">Valor:</label>
            <div class="col-sm-2">
                <input type="text" class="form-control text-center" id="txtPrice" name="txtPrice" value="00,00"
                       readonly>
            </div>
            <label class="col-sm-1 col-form-label" for="txtQuantity">Quantidade:</label>
            <div class="col-sm-1">
                <input type="text" class="form-control text-center" id="txtQuantity" name="txtQuantity" required>
            </div>
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="selPayment">Forma de Pagamento:</label>
            <div class="col-sm-7">
                <select class="form-select" id="selPayment" name="selPayment" required>
                    <option value="0" selected disabled>Selecione uma Forma de Pagamento</option>
                    <option value="1">Dinheiro</option>
                    <option value="2">PIX</option>
                    <option value="3">Cart&atilde;o Debito</option>
                    <option value="4">Cart&atilde;o Cr&eacute;dito</option>
                </select>
            </div>
            <label class="col-sm-1 col-form-label" for="txtTotalValue">Valor Total:</label>
            <div class="col-sm-2">
                <input type="text" readonly class="form-control" id="txtTotalValue" name="txtTotalValue" value="00,00">
            </div>
        </div>
        <%@ include file="components/buttons.jsp" %>
    </div>
</form>
<%@ include file="components/complements_js.jsp" %>
<script src="js/order.js"></script>
</body>
</html>