/**
 * 
 */

$(document).ready(function(){

    $('.nBtn, .table .eBtn').on('click', function(event){

        event.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text();

        if(text=='Edit'){
            $.get(href, function(cadastro, status){
                $('.editnewForm #idCadastro').val(cadastro.idCadastro);
                $('.editnewForm #leitorBiometrico.idLeitor').val(cadastro.leitorBiometrico.idLeitor);
                $('.editnewForm #usuario.idUsuario').val(cadastro.usuario.idUsuario);
                $('.editnewForm #dataCadastro').val(cadastro.dataCadastro);
            });

            $('.editnewForm #editnewModal').modal();
        }else{
            $('.editnewForm #idCadastro').val('');
            $('.editnewForm #idLeitorCadastro').val('');
            $('.editnewForm #idUsuario').val('');
            $('.editnewForm #dataCadastro').val('');

            $('.editnewForm #editnewModal').modal();
        }
    });

    $('.table .delBtn').on('click', function(event){

        event.preventDefault();
        var href = $(this).attr('href');

        $('#deleteModal #delRef').attr('href', href);

        $('#deleteModal').modal();
    });

 });