
function uploadFormData(elem) {
    // $('#result').html('');
    var currentId = $(elem).attr("id");
    var currentNum = currentId.slice(-1);
    var myForm = new FormData();

    // var currentFile = $('#file' + currentNum).attr('name');
    // console.log(currentFile);
    var files = document.getElementById("file" + currentNum);
    for (i = 0; i < files.files.length; i++) {
        myForm.append("file" + i, files.files[i]);
    }
    currentNum++;

    $.ajax({
        url: 'http://localhost:8081/upload',
        data: myForm,
        dataType: 'text',
        processData: false,
        contentType: false,
        type: 'POST',
        success: function (data) {

            $("#imageList").append('<div class="row"><div id="fileRow' + currentNum + '">'+
                '<form id="form' + currentNum + '" method="POST" enctype="multipart/form-data" action="/upload" class="col-xs-6 col-sm-3 col-lg-3">' +
                '<input type="file" multiple="multiple" name="file' + currentNum +'[]" id="file' + currentNum +'"/>' +
                '</form> <button  id ="uploadBtn' +  currentNum +'" value="Submit" onclick="uploadFormData(this)" style="width: 55px" class="col-xs-6 col-sm-3 col-lg-3">Upload</button>' +
                '<button id="clearBtn' + currentNum +'" value="Submit" onclick="deleteImage(this)" style="margin-left: 10px; width: 50px" class="col-xs-6 col-sm-3 col-lg-3">Clear</button></div></div>');
        }
    });
}

function deleteImage(elem) {
    var currentId = $(elem).attr("id");
    var currentNum = currentId.slice(-1);
    if(currentNum > 0) {
        $('#fileRow' + currentNum).hide();
    }
}