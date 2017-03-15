package com.linoge.dao;

import com.linoge.models.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Timo on 13.03.2017.
 */
public interface GroupDAO extends JpaRepository<Group, Long> {
    Group getByGroupNumber(String number);
}
