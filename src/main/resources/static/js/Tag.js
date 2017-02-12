var Tag = {
    tagList: [],
    selectedTags: [],
    addTagToList: function () {
        var tagTitle = $("#tags option:selected").val();
        var tag = _.find(this.tagList, {title: tagTitle});
        if (!_.includes(this.selectedTags, tag.id)) {
            this.selectedTags.push({"id":tag.id});
            $( "#btnList" ).append( '<a href="#" style="font-size: 8pt;">' + tagTitle + '</a>&nbsp&nbsp' );
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