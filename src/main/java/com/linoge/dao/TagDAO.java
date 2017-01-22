package com.linoge.dao;

import com.linoge.models.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Timo on 28.12.2016.
 */
public interface TagDAO extends JpaRepository<Tag, Long> {

}
