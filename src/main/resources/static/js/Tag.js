var Tag = {
    tagList: [],
    selectedTags: [],
    addTagToList: function () {
        var tagTitle = $("#tags option:selected").val();
        var tag = _.find(this.tagList, {title: tagTitle});
        if (!_.includes(this.selectedTags, tag.id)) {
            this.selectedTags.push({"id": tag.id});
            $("#btnList").append('<span class="tag label label-info"><span>' + tagTitle + '</span>' +
                '<a><i class="remove glyphicon glyphicon-remove-sign glyphicon-white"></i></a></span>');
            console.log(this.selectedTags);
        }
    },

    deleteTagFromList: function(){
        var tagTitle = $(this).text();
        console.log(tagTitle);
    },

    getTags: function () {
        $.ajax({
            url: "http://localhost:8081/gettags",
            success: function (data) {
                console.log(data);
                Tag.tagList = data;
                $.each(data, function (id, title) {
                    $('#tags').append(new Option(title.title, id.id));
                });
            }
        });
    },
}