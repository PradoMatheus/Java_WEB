<%@ page import="br.com.fatec.web.domain.Client" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro de Cargo</title>
    <%@ include file="components/css_js.jsp" %>
</head>
<body>
<%@ include file="components/navbar.jsp" %>
<% List<Client> clientList = (List<Client>) request.getAttribute("clientList");%>
<form>
    <div class="container mt-5">
        <div class="py-3 text-center">
            <h2>Lista de Clientes</h2>
        </div>
        <button type="button" id="btnNew" class="btn btn-primary mb-1">
            Novo Cliente
        </button>
        <table class="table table-bordered table-sm" id="datatablesSimple">
            <thead>
            <tr>
                <th scope="col" style="width: 10%; text-align: center;border:1px solid black;">ID</th>
                <th scope="col" style="width: 35%;border:1px solid black;">Nome</th>
                <th scope="col" style="width: 15%; border: 1px solid black;">CPF</th>
                <th scope="col" style="width: 20%; border: 1px solid black;">E-mail</th>
                <th scope="col" style="width: 10%; border: 1px solid black;">Ativo</th>
                <th scope="col" style="width: 10%; border: 1px solid black;">Editar</th>
            </tr>
            </thead>
            <tbody>
            <%
                if (clientList.size() > 0) {
                    for (Client client : clientList) {
                        out.print("<tr>");
                        out.print("<th style='width: 10%;vertical-align: middle;text-align: center'>" + client.getId() + "</th>");
                        out.print("<th style='width: 35%;vertical-align: middle;text-align: center'>" + client.getName() + "</th>");
                        out.print("<th style='width: 15%;vertical-align: middle;text-align: center'>" + client.getCpf() + "</th>");
                        out.print("<th style='width: 20%;vertical-align: middle;text-align: center'>" + client.getEmail() + "</th>");
                        out.print("<th style='width: 10%;vertical-align: middle;text-align: center'>" + client.isActive() + "</th>");
                        out.print("<th style='width: 20%; text-align: center'><a class='btn btn-primary' href='./client?operation=search&id=" + client.getId() + "' role='button'>Editar</a></th>");
                        out.print("</tr>");
                    }
                } else {
            %>
            <tr>
                <td style='text-align: center' colspan='6'>Sem Cliente Cadastrados !</td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</form>
</body>
<%@ include file="components/complements_js.jsp" %>
<script src="js/client.js"></script>
</html>