$('#txtPhone').mask("(00) 00000-0000");
$('#txtZIP').mask("00000-000");
$('#txtCPF').mask("000.000.000-00");

$("#btnNew").click(function () {
    location.href = "client.jsp"
});

$("#btnSearchZIP").click(function () {
    readCEP()
})

function readCEP() {
    let url = 'https://viacep.com.br/ws/' + $("#txtZIP").val() + '/json/'
    let request = new XMLHttpRequest()

    request.open('GET', url, true)
    request.onerror = function (e) {
        alert("API OFFLINE OU CEP INVALIDO")
    }

    request.onload = () => {
        let response = JSON.parse(request.responseText)

        if (response.erro == true)
            alert("CEP Não encontrado")
        else
            $("#txtNeighborhood").val(response.bairro)
            $("#txtCity").val(response.localidade)
            $("#txtAddress").val(response.logradouro)
    }

    request.send()
}