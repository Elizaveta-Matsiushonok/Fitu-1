package com.linoge.servicies;

import com.linoge.models.entities.Tag;
import com.linoge.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Timo on 28.12.2016.
 */
@Service
public class TagServiceImpl implements TagService{

    @Autowired
    TagRepository tagRepository;

    @Override
    public Tag findTagById(Long id) {
        return tagRepository.findOne(id);
    }

    @Override
    public List<Tag> getAll() {
        return tagRepository.findAll();
    }

    @Override
    public void addTag(String title) {
        tagRepository.saveAndFlush(Tag.builder()
                .title(title).build());
    }

    @Override
    public void deleteTagById(Long id) {
        tagRepository.delete(id);
    }
}
