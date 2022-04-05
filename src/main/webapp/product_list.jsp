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
            <h2>Lista de Produtos</h2>
        </div>
        <button type="button" id="btnNew" class="btn btn-primary mb-1">
            Nova Produto
        </button>
        <table class="table table-bordered table-sm" id="datatablesSimple">
            <thead>
            <tr>
                <th scope="col" style="width: 10%; text-align: center;border:1px solid black;">ID</th>
                <th scope="col" style="width: 30%;border:1px solid black;">Nome</th>
                <th scope="col" style="width: 35%; border: 1px solid black;">Descri&ccedil;&atilde;o</th>
                <th scope="col" style="width: 10%; border: 1px solid black;">EAN</th>
                <th scope="col" style="width: 10%; border: 1px solid black;">Categoria</th>
                <th scope="col" style="width: 5%; border: 1px solid black;">Ativo</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td style='text-align: center' colspan='6'>Sem Produtos Cadastrados !</td>
            </tr>
            </tbody>
        </table>
    </div>
</form>
</body>
<%@ include file="components/complements_js.jsp" %>
<script src="js/product.js"></script>
</html>