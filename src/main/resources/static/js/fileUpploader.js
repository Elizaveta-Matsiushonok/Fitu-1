/**
 * Created by Timo on 14.02.2017.
 */
function uploadFormData(){
    $('#result').html('');
    var myForm = new FormData();
    myForm.append("file", file2.files[0]);

    $.ajax({
        url: 'http://localhost:8081/upload',
        data: myForm,
        dataType: 'text',
        processData: false,
        contentType: false,
        type: 'POST',
        success: function(data){
            //  $('#result').html(data+ " uploaded by FormData!");
            $('#result').html(data);
        }
    });
}