<%@ page import="br.com.fatec.web.domain.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro de Cargo</title>
    <%@ include file="components/css_js.jsp" %>
</head>
<body>
<%@ include file="components/navbar.jsp" %>
<% List<Product> productList = (List<Product>) request.getAttribute("productList");%>
<form>
    <div class="container mt-5">
        <div class="py-3 text-center">
            <h2>Lista de Produtos</h2>
        </div>
        <button type="button" id="btnNew" class="btn btn-primary mb-1">
            Nova Produto
        </button>
        <table class="table table-bordered table-sm" id="datatablesSimple">
            <thead>
            <tr>
                <th scope="col" style="width: 10%; text-align: center;border:1px solid black;">ID</th>
                <th scope="col" style="width: 25%;border:1px solid black;">Nome</th>
                <th scope="col" style="width: 30%; border: 1px solid black;">Descri&ccedil;&atilde;o</th>
                <th scope="col" style="width: 10%; border: 1px solid black;">EAN</th>
                <th scope="col" style="width: 10%; border: 1px solid black;">Categoria</th>
                <th scope="col" style="width: 5%; border: 1px solid black;">Ativo</th>
                <th scope="col" style="width: 10%; border: 1px solid black;">Editar</th>
            </tr>
            </thead>
            <tbody>
            <%
                if (productList.size() > 0) {
                    for (Product product : productList) {
                        out.print("<tr>");
                        out.print("<th style='width: 10%;vertical-align: middle;text-align: center'>" + product.getId() + "</th>");
                        out.print("<th style='width: 25%;vertical-align: middle;text-align: center'>" + product.getName() + "</th>");
                        out.print("<th style='width: 30%;vertical-align: middle;text-align: center'>" + product.getDescription() + "</th>");
                        out.print("<th style='width: 10%;vertical-align: middle;text-align: center'>" + product.getEan() + "</th>");
                        out.print("<th style='width: 10%;vertical-align: middle;text-align: center'>" + product.getCategory().getName() + "</th>");
                        out.print("<th style='width: 5%;vertical-align: middle;text-align: center'>" + product.isActive() + "</th>");
                        out.print("<th style='width: 10%; text-align: center'><a class='btn btn-primary' href='./product?operation=search&id=" + product.getId() + "&type=normal' role='button'>Editar</a></th>");
                        out.print("</tr>");
                    }
                } else {
            %>
            <tr>
                <td style='text-align: center' colspan='6'>Sem Produtos Cadastrados !</td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</form>
</body>
<%@ include file="components/complements_js.jsp" %>
<script src="js/product.js"></script>
</html>