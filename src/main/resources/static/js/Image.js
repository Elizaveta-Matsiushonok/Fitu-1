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
                Image.imageArray.push(data[0]);
                Image.displayImageArray(Image.imageArray);
            }
        });
    },

    displayImageArray: function (imageArray) {
        _.forEach(imageArray, function (object){
            var index = _.findIndex(imageArray, (function(obj){
                return obj.id == object.id;
            }));
            $('#result').append('<div id="image' + index + '">' +
                '<div id="img' + index +'"><div class="col-md-4 col-sm-4 col-xs-12">' +
                '<a href="#portfolioBig2"  data-toggle="modal">' + object.path + '</a></div></div></div>');
            $('img').addClass('img-responsive');
            $('#image' + index).append('<button id="deleteImageBtn' +index +'" value="Submit" onclick="Image.deleteImage(this)"'+
                'class="col-xs-6 col-sm-3 col-lg-3" >Delete</button>');
        });
    },

    deleteImage: function (elem) {
        $('#file').val('');
        $('#result').val('');
        var image = $(elem).attr('id').substr(-1);
        var imageId = Image.imageArray[image].id;
        $.ajax({
            url: 'http://localhost:8081/deleteimage',
            data: {"id":imageId},
            dataType: 'json',
            processData: false,
            contentType: false,
            type: 'POST',
            success: function (data) {
                console.log("OK");
            }
        });
    }
};