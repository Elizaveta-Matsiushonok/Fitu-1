package com.linoge.servicies;

import com.linoge.models.entities.Tag;

import java.util.List;

/**
 * Created by Timo on 28.12.2016.
 */
public interface TagService{
    Tag findTagById(Long id);

    List<Tag> getAll();

    void addTag(String title);

    void deleteTagById(Long id);
}
