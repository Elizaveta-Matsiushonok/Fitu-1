package com.linoge.repositories;

import com.linoge.models.entities.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Timo on 28.12.2016.
 */
@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
}
