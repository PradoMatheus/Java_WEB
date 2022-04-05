<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro de Cargo</title>
    <%@ include file="components/css_js.jsp" %>
</head>
<body>
<%@ include file="components/navbar.jsp" %>
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
                <th scope="col" style="width: 50%;border:1px solid black;">Cliente</th>
                <th scope="col" style="width: 25%; border: 1px solid black;">Valor</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td style='text-align: center' colspan='4'>Sem Pedidos Cadastrados !</td>
            </tr>
            </tbody>
        </table>
    </div>
</form>
</body>
<%@ include file="components/complements_js.jsp" %>
<script src="js/order.js"></script>
</html>