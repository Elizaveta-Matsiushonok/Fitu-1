package com.linoge.dao;

import com.linoge.models.entities.Article;
import com.linoge.models.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Timo on 28.12.2016.
 */
@Repository
public interface ArticleDAO extends JpaRepository<Article, Long> {
    List<Article> findByTagsContaining(Tag tagById);
}
