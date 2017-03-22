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
        $('#deleteBtnArray').html('');
        _.forEach(imageArray, function (object){
            var index = _.findIndex(imageArray, (function(obj){
                return obj.id == object.id;
            }));
            $('#result').append('<div class="img-article"><div id="image' + index + '" >' +
                '<div id="img' + index +'"><div><a data-toggle="modal">' + object.path + '</a></div></div></div>' +
                '<button id="deleteImageBtn' +index +'" type="Submit" onclick="Image.deleteImage(this)">Delete</button></div>');
            $('img').addClass('img-responsive');
        });
    },

    deleteImage: function (elem) {
        $('#file').val('');
        var index = $(elem).attr('id').substr(-1);
        var imageId = Image.imageArray[index].id;
        $.ajax({
            url: 'http://localhost:8081/deleteimage',
            data: {"id":imageId},
            type: 'POST',
            success: function (data) {
                $('#result').html('');
                Image.imageArray.splice(index, 1);
                Image.displayImageArray(Image.imageArray);
                console.log("OK");
            }
        });
    }
};