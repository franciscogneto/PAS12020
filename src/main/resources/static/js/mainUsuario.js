/**
 * 
 */

$(document).ready(function(){

    $('.nBtn, .table .eBtn').on('click', function(event){

        event.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text();

        if(text=='Edit'){
            $.get(href, function(usuario, status){
                $('.editForm #id').val(usuario.id);
                $('.editForm #nome').val(usuario.nome);
                $('.editForm #cpf').val(usuario.cpf);
                $('.editForm #datanasc').val(usuario.datanasc);
                $('.editForm #cidade').val(usuario.cidade);
                $('.editForm #endereco').val(usuario.endereco);
                $('.editForm #email').val(usuario.email);
                $('.editForm #telefone').val(usuario.telefone);
                $('.editForm #celular').val(usuario.celular);
            });

            $('.editForm #editModal').modal();
        }else{
            $('.newForm #nome').val('');
            $('.newForm #cpf').val('');
            $('.newForm #datanasc').val('');
            $('.newForm #cidade').val('');
            $('.newForm #endereco').val('');
            $('.newForm #email').val('');
            $('.newForm #telefone').val('');
            $('.newForm #celular').val('');

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