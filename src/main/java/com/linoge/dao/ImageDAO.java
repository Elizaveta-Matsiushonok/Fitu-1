package com.linoge.dao;

import com.linoge.models.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Timo on 17.02.2017.
 */
@Repository
public interface ImageDAO extends JpaRepository<Image, Long> {
}
