var Image = {
    imageArray: [],
    uploadFormData: function (elem) {
        $('#result').html('');
        var myForm = new FormData();
        var files = document.getElementById("file");
        for (i = 0; i < files.files.length; i++) {
            myForm.append("file" + i, files.files[i]);
        }
        $.ajax({
            url: 'http://localhost:8081/upload',
            data: myForm,
            dataType: 'json',
            processData: false,
            contentType: false,
            type: 'POST',
            success: function (data) {
                Image.imageArray.push(data);
                // var imageIndex =  _.indexOf(Image.imageArray, data);
                Image.displayImageArray(Image.imageArray);
            }
        });
    },

    displayImageArray: function (imageArray) {
        _.forEach(imageArray, function (object){
            var index = _.findIndex(imageArray, (function(obj){
                return obj.id == object.id;
            }));
            console.log(index);
            $('#result').append('<div id="img' + index +'"><div class="col-md-4 col-sm-4 col-xs-12">' +
                '<a href="#portfolioBig2"  data-toggle="modal">'
                + object.path +
                '</a></div></div>');
            $('img' + index).addClass('img-responsive');
            $('imageList').append('<button id="deleteImageBtn' +index +'" value="Submit" onclick="Image.deleteImage(this)"'+
                'class="col-xs-6 col-sm-3 col-lg-3 "  style="margin-top: 10px; width: 50px">Delete</button>');
        });
    },



    // $("#imageList").append('<div class="row"><div id="fileRow' + currentNum + '">'+
    //     '<form id="form' + currentNum + '" method="POST" enctype="multipart/form-data" action="/upload" class="col-xs-6 col-sm-3 col-lg-3">' +
    //     '<input type="file" multiple="multiple" name="file' + currentNum +'[]" id="file' + currentNum +'"/>' +
    //     '</form> <button  id ="uploadBtn' +  currentNum +'" value="Submit" onclick="uploadFormData(this)" style="width: 55px" class="col-xs-6 col-sm-3 col-lg-3">Upload</button>' +
    //     '<button id="clearBtn' + currentNum +'" value="Submit" onclick="deleteImage(this)" style="margin-left: 10px; width: 50px" class="col-xs-6 col-sm-3 col-lg-3">Clear</button>'+
    //     '<div id="result' + currentNum + '"></div></div></div>');

    deleteImage: function (elem) {
        $('#file').val('');
        $('#result').val('');

    }
};