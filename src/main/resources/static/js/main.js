$(document).ready( function () {
    $('#mydatatable').DataTable({
        scrollY: 400,
        scrollX: true,
        scrollCollapse: true,
        paging: false
    });
} );
// $('#mydatatable thead th').each( function () {
//     var title = $(this).text();
//     $(this).html('<input type="text" style="width: 100%" placeholder="Search '+ title +'"/>');
// });
//
// table.columns().every( function () {
//     var that = this;
//     $('input', this.header()).on('keyup change', function () {
//         if (that.search() !== this.value) {
//             that.search(this.value).draw();
//         }
//     })
// });