var Tag = {
    tagList: [],
    selectedTags: [],
    addTagToList: function () {
        var tagTitle = $("#tags option:selected").val();
        var tag = _.find(this.tagList, {title: tagTitle});
        if (!_.includes(this.selectedTags, tag.id)) {
            this.selectedTags.push(tag.id);
            var r = $('<input type="button" value="tagTitle"/>');
            var r= $('<div class="col-sm-4 alert alert-info alert-dismissable"  style="margin-left: 13%;  margin-top: 10px; width: 30px;">' +
                '<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>' + tagTitle +
           ' </div> ');
            $('body').append(r);
        }
        console.log(this.selectedTags);
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