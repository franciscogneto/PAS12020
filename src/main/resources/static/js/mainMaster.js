/**
 * 
 */

$(document).ready(function(){
    
    $('.eBtn').on('click', function(event){

        event.preventDefault();
        var href = $(this).attr('href');

        $.get(href, function(master, status){
            $('.editForm #id').val(master.id);
            $('.editForm #usuario').val('');
            $('.editForm #password').val('');
        });
   
        $('.editForm #editModal').modal();
    });
 });