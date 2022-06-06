<%@ page import="br.com.fatec.web.domain.Client" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro de Clientes</title>
    <%@ include file="components/css_js.jsp" %>
</head>
<body>
<%@ include file="components/navbar.jsp" %>
<% Client client = new Client();
    if (request.getAttribute("client") != null) {
        client = (Client) request.getAttribute("client");
    }%>
<form method="get" action="client">
    <div class="container mt-5">
        <div class="fs-2 fw-bold text-center">
            Cadastro de Cliente
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="txtCod">C&oacute;digo:</label>
            <div class="col-sm-1">
                <input type="text" class="form-control text-center" id="txtCod" name="txtCod"
                       value="<%if (client.getId() > 0) out.print(client.getId()); else out.print(0);%>" readonly>
            </div>
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="txtName">Nome:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="txtName" name="txtName"
                       placeholder="Digite o nome do cliente" required="required"
                       value="<%if (client.getId() > 0) out.print(client.getName()); else out.print("");%>">
            </div>
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="txtCPF">CPF:</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="txtCPF" name="txtCPF" placeholder="XXX.XXX.XXX-XX"
                       required="required"
                       value="<%if (client.getId() > 0) out.print(client.getCpf()); else out.print("");%>">
            </div>
            <label class="col-sm-1 col-form-label" for="txtEmail">E-mail:</label>
            <div class="col-sm-5">
                <input type="email" class="form-control" id="txtEmail" name="txtEmail" placeholder="seuemail@gmail.com"
                       required="required"
                       value="<%if (client.getId() > 0) out.print(client.getEmail()); else out.print("");%>">
            </div>
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="txtPhone">Telefone:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="txtPhone" name="txtPhone" placeholder="(XX) XXXXX-XXXX"
                       required="required"
                       value="<%if (client.getId() > 0) out.print(client.getCellphone()); else out.print("");%>">
            </div>
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="txtZIP">CEP:</label>
            <div class="col-sm-2">
                <input type="text" class="form-control" id="txtZIP" name="txtZIP" placeholder="XXXXX-XXX"
                       required="required"
                       value="<%if (client.getId() > 0) out.print(client.getZip()); else out.print("");%>">
            </div>
            <div class="col-sm-2">
                <button type="button" class="btn btn-primary" id="btnSearchZIP"><i class="fa fa-search"></i> Buscar
                </button>
            </div>
            <label class="col-sm-1 col-form-label" for="txtCity">Cidade:</label>
            <div class="col-sm-2">
                <input type="text" class="form-control" id="txtCity" name="txtCity" required="required"
                       value="<%if (client.getId() > 0) out.print(client.getCity()); else out.print("");%>">
            </div>
            <label class="col-sm-1 col-form-label" for="txtNeighborhood">Bairro:</label>
            <div class="col-sm-2">
                <input type="text" class="form-control" id="txtNeighborhood" name="txtNeighborhood" required="required"
                       value="<%if (client.getId() > 0) out.print(client.getDistrict()); else out.print("");%>">
            </div>
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="txtAddress">Endereço:</label>
            <div class="col-sm-7">
                <input type="text" class="form-control" id="txtAddress" name="txtAddress" placeholder="Endereço"
                       required="required"
                       value="<%if (client.getId() > 0) out.print(client.getAddress()); else out.print("");%>">
            </div>
            <label class="col-sm-1 col-form-label" for="txtNumber">Nª:</label>
            <div class="col-sm-2">
                <input type="text" class="form-control" id="txtNumber" name="txtNumber" placeholder="Número"
                       required="required"
                       value="<%if (client.getId() > 0) out.print(client.getNumber_house()); else out.print("");%>">
            </div>
        </div>
        <div class="form-group row m-1">
            <label class="col-sm-2 col-form-label" for="txtEnable">Ativo:</label>
            <div class="col-sm-10">
                <input type="checkbox" class="form-check-input" id="txtEnable" name="txtEnable" value=true
                    <%if (client.isActive() == true) out.print("checked"); else out.print("");%>>
            </div>
        </div>
        <%@ include file="components/buttons.jsp" %>
    </div>
</form>
<%@ include file="components/complements_js.jsp" %>
<script src="js/client.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $("#txtEnable").on("change", function (){
            if (this.checked)
                console.log(true)
            else
                console.log(false)
        })
        if (parseInt($("#txtCod").val()) > 0)
            $("#btn_delete").prop("disabled", false);
    })
</script>
</body>
</html>
