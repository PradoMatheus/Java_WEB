<%@ page import="br.com.fatec.web.domain.Role" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro de Cargo</title>
    <%@ include file="components/css_js.jsp" %>
</head>
<body>
<%@ include file="components/navbar.jsp" %>
<% List<Role> roleList = (List<Role>) request.getAttribute("roleList");%>
<form>
    <div class="container mt-5">
        <div class="py-3 text-center">
            <h2>Lista de Cargos</h2>
        </div>
        <button type="button" id="btnNew" class="btn btn-primary mb-1">
            Novo Cargo
        </button>
        <table class="table table-bordered table-sm" id="datatablesSimple">
            <thead>
            <tr>
                <th scope="col" style="width: 10%; text-align: center;border:1px solid black;">ID</th>
                <th scope="col" style="width: 30%;border:1px solid black;">Nome</th>
                <th scope="col" style="width: 40%; border: 1px solid black;">Observação</th>
                <th scope="col" style="width: 10%; text-align: center;border:1px solid black;">Ativo</th>
                <th scope="col" style="width: 10%; border: 1px solid black;">Editar</th>
            </tr>
            </thead>
            <tbody>
            <%
                if (roleList.size() > 0) {
                    for (Role role : roleList) {
                        out.print("<tr>");
                        out.print("<th style='width: 10%;vertical-align: middle;text-align: center'>" + role.getId() + "</th>");
                        out.print("<th style='width: 30%;vertical-align: middle;text-align: center'>" + role.getName() + "</th>");
                        out.print("<th style='width: 40%;vertical-align: middle;text-align: center'>" + role.getObservation() + "</th>");
                        out.print("<th style='width: 10%;vertical-align: middle;text-align: center'>" + role.isActive() + "</th>");
                        out.print("<th style='width: 10%; text-align: center'><a class='btn btn-primary' href='./role?operation=search&id=" + role.getId() + "' role='button'>Editar</a></th>");
                        out.print("</tr>");
                    }
                } else {
            %>
            <tr>
                <td style='text-align: center' colspan='5'>Sem Cargos Cadastrados !</td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</form>
</body>
<%@ include file="components/complements_js.jsp" %>
<script src="js/role.js"></script>
</html>