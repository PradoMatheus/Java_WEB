<%@ page import="java.util.List" %>
<%@ page import="br.com.fatec.web.domain.Category" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro de Cargo</title>
    <%@ include file="components/css_js.jsp" %>
</head>
<body>
<%@ include file="components/navbar.jsp" %>
<% List<Category> categoryList = (List<Category>) request.getAttribute("categoryList");%>
<form>
    <div class="container mt-5">
        <div class="py-3 text-center">
            <h2>Lista de Categorais</h2>
        </div>
        <button type="button" id="btnNew" class="btn btn-primary mb-1">
            Nova Categoria
        </button>
        <table class="table table-bordered table-sm" id="datatablesSimple">
            <thead>
            <tr>
                <th scope="col" style="width: 10%; text-align: center;border:1px solid black;">ID</th>
                <th scope="col" style="width: 30%; text-align: center;border:1px solid black;">Nome</th>
                <th scope="col" style="width: 50%; text-align: center;border: 1px solid black;">Observação</th>
                <th scope="col" style="width: 10%; text-align: center;border: 1px solid black;">Editar</th>
            </tr>
            </thead>
            <tbody>
            <%
                if (categoryList.size() > 0) {
                    for (Category category : categoryList) {
                        out.print("<tr>");
                        out.print("<th style='width: 10%;vertical-align: middle;text-align: center'>" + category.getId() + "</th>");
                        out.print("<th style='width: 30%;vertical-align: middle;text-align: center'>" + category.getName() + "</th>");
                        out.print("<th style='width: 50%;vertical-align: middle;text-align: center'>" + category.getObservation() + "</th>");
                        out.print("<th style='width: 10%; text-align: center'><a class='btn btn-primary' href='./category?operation=search&id=" + category.getId() + "' role='button'>Editar</a></th>");
                        out.print("</tr>");
                    }
                } else {
            %>
            <tr>
                <td style='text-align: center' colspan='4'>Sem Categorias Cadastradas !</td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</form>
</body>
<%@ include file="components/complements_js.jsp" %>
<script src="js/category.js"></script>
</html>