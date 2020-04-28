/**
 * 
 */

$(document).ready(function(){
    
    $('.eBtn').on('click', function(event){

        event.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text();

        if(text=='EDIT '){
            $('.editForm #usuario').val('');
            $('.editForm #password').val('');
            
            $('.editForm #editModal').modal();
        }else{
            $.get(href, function(master, status){
                $('.editForm #id').val('');
                $('.newForm #usuario').val('');
                $('.newForm #password').val('');
            });

            $('.newForm #newModal').modal();
        }
    });
 });