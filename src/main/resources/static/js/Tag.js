var Tag = {
    tagList: [],
    selectedTags: [],
    addTagToList: function () {
        var tagTitle = $("#tags option:selected").val();
        var tag = _.find(this.tagList, {title: tagTitle});
        if (!_.includes(this.selectedTags, tag.id)) {
            this.selectedTags.push({"id": tag.id});
            $("#btnList").append('<div id="tag' + tag.id +'"><span class="tag label label-info"><span>' + tagTitle + '</span>' +
                '<a><i id="crossId' + tag.id +'" class="remove glyphicon glyphicon-remove-sign glyphicon-white" onclick="Tag.deleteTagFromList(this)"></i></a></span></div>');
        }
    },

    deleteTagFromList: function(elem){
        var currentId = $(elem).attr("id");
        var currentNum = currentId.slice(-1);
            $('#tag' + currentNum).hide();
    },

    getTags: function () {
        $.ajax({
            url: "http://localhost:8081/gettags",
            success: function (data) {
                Tag.tagList = data;
                $.each(data, function (id, title) {
                    $('#tags').append(new Option(title.title, id.id));
                });
            }
        });
    },
}