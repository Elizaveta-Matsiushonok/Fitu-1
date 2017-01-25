var Article = {
    article: {},
    postArticle: function postArticle() {
        var article = {};
        article.title = $('#title').val();
        article.text = CKEDITOR.instances.editor1.getData();
        article.tags = Tag.selectedTags;
        $.ajax({
            type: "POST",
            url: "http://localhost:8081/addarticle",
            data: article,
            success: function () {
                console.log(' 200 OK');
            }
        });
    },
    rewrite: function postArticle() {
        var article = {};
        article.title = $('#title').val();
        article.text = CKEDITOR.instances.editor1.getData();
        article.tags = Tag.selectedTags;
        $.ajax({
            type: "POST",
            url: "http://localhost:8081/rewritearticle",
            data: article,
            success: function () {
                console.log(' 200 OK');
            }
        });
    },

    addTag: function () {
        CKEDITOR.instances.editor1.insertText('<{<article_body>}>');
    },

    getArticleByTag: function (id) {
        var params = {};
        params.tag_id = id;
        $.ajax({
            url: "http://localhost:8081/getarticlebytag",
            data: params,
            success: function (data) {
                //TODO set data to element
                console.log(data);
            }
        });
    },

    getArticleById: function (id) {
        var params = {};
        params.article_id = id;
        $.ajax({
            url: "http://localhost:8081/getarticlebyid",
            data: params,
            success: function (data) {
                //TODO set data to element
                this.article = data;
                console.log(data);
            }
        });
    },
    deleteArticle: function (id) {
        var params = {};
        params.id = id;
        $.ajax({
            url: "http://localhost:8081/deletearticle",
            data: params,
            success: function () {
                console.log("article was deleting");
            }
        });
    }
};


