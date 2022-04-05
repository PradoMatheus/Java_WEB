<%@ page import="br.com.fatec.web.domain.Collaborator" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro de Cargo</title>
    <%@ include file="components/css_js.jsp" %>
</head>
<body>
<%@ include file="components/navbar.jsp" %>
<% List<Collaborator> collaboratorList = (List<Collaborator>) request.getAttribute("collaboratorList");%>
<form>
    <div class="container mt-5">
        <div class="py-3 text-center">
            <h2>Lista de Colaboradores</h2>
        </div>
        <button type="button" id="btnNew" class="btn btn-primary mb-1">
            Novo Colaborador
        </button>
        <table class="table table-bordered table-sm" id="datatablesSimple">
            <thead>
            <tr>
                <th scope="col" style="width: 10%; text-align: center;border:1px solid black;">ID</th>
                <th scope="col" style="width: 35%;border:1px solid black;">Nome</th>
                <th scope="col" style="width: 15%; border: 1px solid black;">Cargo</th>
                <th scope="col" style="width: 20%; border: 1px solid black;">E-mail</th>
                <th scope="col" style="width: 10%; border: 1px solid black;">Ativo</th>
                <th scope="col" style="width: 10%; border: 1px solid black;">Editar</th>
            </tr>
            </thead>
            <tbody>
            <%
                if (collaboratorList.size() > 0) {
                    for (Collaborator collaborator : collaboratorList) {
                        out.print("<tr>");
                        out.print("<th style='width: 10%;vertical-align: middle;text-align: center'>" + collaborator.getId() + "</th>");
                        out.print("<th style='width: 35%;vertical-align: middle;text-align: center'>" + collaborator.getName() + "</th>");
                        out.print("<th style='width: 15%;vertical-align: middle;text-align: center'>" + collaborator.getRole().getName() + "</th>");
                        out.print("<th style='width: 10%;vertical-align: middle;text-align: center'>" + collaborator.getEmail() + "</th>");
                        out.print("<th style='width: 10%;vertical-align: middle;text-align: center'>" + collaborator.isActive() + "</th>");
                        out.print("<th style='width: 10%; text-align: center'><a class='btn btn-primary' href='./collaborator?operation=search' role='button'>Editar</a></th>");
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
<script src="js/collaborator.js"></script>
</html>