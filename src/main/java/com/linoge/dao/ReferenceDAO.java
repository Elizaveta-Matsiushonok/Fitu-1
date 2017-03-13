package com.linoge.dao;

import com.linoge.models.entities.Reference;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Timo on 13.03.2017.
 */
public interface ReferenceDAO extends JpaRepository<Reference, Long> {
}
