package com.linoge.repositories;

import com.linoge.models.dto.NewsDTO;
import com.linoge.models.entities.News;
import com.linoge.models.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Timo on 28.12.2016.
 */
@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    List<News> findByTagsContaining(Tag tagById);
}
