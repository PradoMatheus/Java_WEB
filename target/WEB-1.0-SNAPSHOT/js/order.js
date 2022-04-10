$('#txtQuantity').mask("#0");

$("#btnNew").click(function () {
    location.href = "order.jsp"
});

$(document).ready(function () {
    $('#datatablesSimple').DataTable({
        "language": {
            "url": "//cdn.datatables.net/plug-ins/1.11.1/i18n/pt_br.json"
        }
    });
})