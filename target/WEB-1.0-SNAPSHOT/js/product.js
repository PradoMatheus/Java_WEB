$('#txtValue').mask("#.##0,00", {reverse: true});

$("#btnNew").click(function () {
    location.href = "product.jsp"
});

$(document).ready(function () {
    $('#datatablesSimple').DataTable({
        "language": {
            "url": "//cdn.datatables.net/plug-ins/1.11.1/i18n/pt_br.json"
        }
    });
})