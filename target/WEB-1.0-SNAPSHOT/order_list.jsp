<%@ page import="br.com.fatec.web.domain.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro de Cargo</title>
    <%@ include file="components/css_js.jsp" %>
</head>
<body>
<%@ include file="components/navbar.jsp" %>
<% List<Order> orderList = (List<Order>) request.getAttribute("orderList");
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");%>
<form>
    <div class="container mt-5">
        <div class="py-3 text-center">
            <h2>Lista de Pedidos</h2>
        </div>
        <button type="button" id="btnNew" class="btn btn-primary mb-1">
            Novo Pedido
        </button>
        <table class="table table-bordered table-sm" id="datatablesSimple">
            <thead>
            <tr>
                <th scope="col" style="width: 10%; text-align: center;border:1px solid black;">ID</th>
                <th scope="col" style="width: 15%;border:1px solid black;">Data do Pedido</th>
                <th scope="col" style="width: 40%;border:1px solid black;">Cliente</th>
                <th scope="col" style="width: 25%; border: 1px solid black;">Valor</th>
                <th scope="col" style="width: 10%; border: 1px solid black;">Editar</th>
            </tr>
            </thead>
            <tbody>
            <%
                if (orderList.size() > 0) {
                    for (Order order : orderList) {
                        out.print("<tr>");
                        out.print("<th style='width: 10%;vertical-align: middle;text-align: center'>" + order.getId() + "</th>");
                        out.print("<th style='width: 15%;vertical-align: middle;text-align: center'>" + order.getDate_order().format(formatter) + "</th>");
                        out.print("<th style='width: 40%;vertical-align: middle;text-align: center'>" + order.getClient().getName() + "</th>");
                        out.print("<th style='width: 25%;vertical-align: middle;text-align: center'>" + order.getTotal_value() + "</th>");
                        out.print("<th style='width: 10%; text-align: center'><a class='btn btn-primary' href='./order?operation=search' role='button'>Editar</a></th>");
                        out.print("</tr>");
                    }
                } else {
            %>
            <tr>
                <td style='text-align: center' colspan='5'>Sem Pedidos Cadastrados !</td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</form>
</body>
<%@ include file="components/complements_js.jsp" %>
<script src="js/order.js"></script>
</html>