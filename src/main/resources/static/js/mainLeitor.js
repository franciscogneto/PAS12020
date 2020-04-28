/**
 * 
 */

$(document).ready(function(){

    $('.nBtn, .table .eBtn').on('click', function(event){

        event.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text();

        if(text=='Edit'){
            $.get(href, function(leitor, status){
                $('.editForm #idLeitor').val(leitor.idLeitor);
                $('.editForm #local').val(leitor.local);
                $('.editForm #capacidade').val(leitor.capacidade);
                $('.editForm #fabricante').val(leitor.fabricante);
                $('.editForm #senha').val(leitor.senha);
            });

            $('.editForm #editModal').modal();
        }else{
            $('.newForm #local').val('');
            $('.newForm #capacidade').val('');
            $('.newForm #fabricante').val('');
            $('.newForm #senha').val('');

            $('.newForm #newModal').modal();
        }
    });

    $('.table .delBtn').on('click', function(event){

        event.preventDefault();
        var href = $(this).attr('href');

        $('#deleteModal #delRef').attr('href', href);

        $('#deleteModal').modal();
    });

 });