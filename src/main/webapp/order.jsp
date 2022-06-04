<%@ page import="br.com.fatec.web.domain.Order" %>
<%@ page import="br.com.fatec.web.domain.Order_Item" %>
<%@ page import="br.com.fatec.web.domain.Payment" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Cadastros de Produto</title>
    <%@ include file="components/css_js.jsp" %>
</head>
<body>
<%@ include file="components/navbar.jsp" %>
<%
    Order order = new Order();
    Payment payment = new Payment();
    order.setPayment(payment);
    if (request.getAttribute("order") != null) {
        order = (Order) request.getAttribute("order");
    }%>
<form method="post" action="order">
    <div class="container mt-5">
        <div class="fs-2 fw-bold text-center">
            Cadastro de Pedido
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="txtCod">C&oacute;digo:</label>
            <div class="col-sm-1">
                <input type="text" class="form-control text-center" id="txtCod" name="txtCod"
                       value="<%if (order.getId() > 0) out.print(order.getId()); else out.print(0);%>" readonly>
            </div>
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="selClient">Cliente:</label>
            <div class="col-sm-10">
                <select class="form-select" id="selClient" name="selClient" required>
                    <option value="0" selected disabled>Selecione um cliente</option>
                </select>
            </div>
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="selVendor">Vendedor:</label>
            <div class="col-sm-10">
                <select class="form-select" id="selVendor" name="selVendor" required>
                    <option value="0" selected disabled>Selecione um vendedor</option>
                </select>
            </div>
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="selProduct">Produto:</label>
            <div class="col-sm-5">
                <select class="form-select" id="selProduct" name="selProduct" required>
                    <option value="0" selected disabled>Selecione um produto</option>
                </select>
            </div>
            <label class="col-sm-1 col-form-label" for="txtPrice">Valor:</label>
            <div class="col-sm-2">
                <input type="text" class="form-control text-center" id="txtPrice" name="txtPrice"
                       value="<%if (order.getId() > 0) for (Order_Item order_item: order.getOrder_items()) out.print(order_item.getValue()); else out.print(1);%>"
                       readonly>
            </div>
            <label class="col-sm-1 col-form-label" for="txtQuantity">Quantidade:</label>
            <div class="col-sm-1">
                <input type="number" min="1" max="100" class="form-control text-center" id="txtQuantity"
                       name="txtQuantity"
                       value="<%if (order.getId() > 0) for (Order_Item order_item: order.getOrder_items()) out.print(order_item.getQuantity()); else out.print(1);%>"
                       required>
            </div>
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="selPayment">Forma de Pagamento:</label>
            <div class="col-sm-7">
                <select class="form-select" id="selPayment" name="selPayment" required>
                    <option value="0" selected disabled>Selecione uma Forma de Pagamento</option>
                    <option value="1" <% if (order.getPayment().getId() == 1) out.print("selected");%>>Dinheiro</option>
                    <option value="2" <% if (order.getPayment().getId() == 2) out.print("selected");%>>PIX</option>
                    <option value="3" <% if (order.getPayment().getId() == 3) out.print("selected");%>>Cart&atilde;o
                        Debito
                    </option>
                    <option value="4" <% if (order.getPayment().getId() == 4) out.print("selected");%>>Cart&atilde;o Cr&eacute;dito</option>
                </select>
            </div>
            <label class="col-sm-1 col-form-label" for="txtTotalValue">Valor Total:</label>
            <div class="col-sm-2">
                <input type="text" readonly class="form-control" id="txtTotalValue" name="txtTotalValue"
                       value="<%if (order.getId() > 0) out.print(order.getTotal_value()); else out.print(0);%>">
            </div>
        </div>
        <%@ include file="components/buttons.jsp" %>
    </div>
    <script type="text/javascript">
        var value_product = 0.0;
        $(document).ready(function () {
            if (parseInt($("#txtCod").val()) > 0) {
                $("#btn_delete").prop("disabled", false);
                value_product = parseFloat(document.getElementById("txtPrice").value)
            }
            $.get("client?operation=list&type=gson", function (value) {
                value.forEach(function (client) {
                    <%if(order.getId() > 0){%>
                    if (client.id == <%out.print(order.getClient().getId());%>)
                        $("#selClient").append('<option value="' + client.id + '" selected >' + client.name + '</option>')
                    else
                        $("#selClient").append('<option value="' + client.id + '">' + client.name + '</option>')
                    <%}else {%>
                    $("#selClient").append('<option value="' + client.id + '">' + client.name + '</option>')
                    <%}%>
                })
            })
            $.get("collaborator?operation=list&type=gson", function (value) {
                value.forEach(function (collaborator) {
                    <%if(order.getId() > 0){%>
                    if (collaborator.id == <%out.print(order.getCollaborator().getId());%>)
                        $("#selVendor").append('<option value="' + collaborator.id + ' " selected >' + collaborator.name + '</option>')
                    else
                        $("#selVendor").append('<option value="' + collaborator.id + '">' + collaborator.name + '</option>')
                    <%}else {%>
                    $("#selVendor").append('<option value="' + collaborator.id + '">' + collaborator.name + '</option>')
                    <%}%>
                })
            })
            $.get("product?operation=list&type=gson", function (value) {
                value.forEach(function (product) {
                    <%if(order.getId() > 0){%>
                    if (product.id == 4)
                        $("#selProduct").append('<option value="' + product.id + '" selected>' + product.name + '</option>')
                    else
                        $("#selProduct").append('<option value="' + product.id + '">' + product.name + '</option>')
                    <%}else {%>
                    $("#selProduct").append('<option value="' + product.id + '">' + product.name + '</option>')
                    <%}%>
                })
            })
        })
        $('#selProduct').on('change', function () {
            $.get("product?operation=search&id=" + parseInt(this.value) + "&type=gson", function (value) {
                document.getElementById("txtPrice").value = value.value
                value_product = value.value
                update_value_total()
            })
        })
        $('#txtQuantity').on('change', function () {
            $.get("product?operation=search&id=" + parseInt(this.value) + "&type=gson", function (value) {
                update_value_total()
            })
        })

        function update_value_total() {
            document.getElementById("txtTotalValue").value = (parseInt(document.getElementById("txtQuantity").value) * value_product).toFixed(2)
        }
    </script>
</form>
<%@ include file="components/complements_js.jsp" %>
<script src="js/order.js"></script>
</body>
</html>