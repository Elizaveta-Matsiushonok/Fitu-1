package com.linoge.servicies.implementations;

import com.linoge.models.entities.Tag;
import com.linoge.dao.TagDAO;
import com.linoge.servicies.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Timo on 28.12.2016.
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagDAO tagDAO;

    @Override
    public Tag findTagById(Long id) {
        return tagDAO.findOne(id);
    }

    @Override
    public List<Tag> getAll() {
        return tagDAO.findAll();
    }

    @Override
    public void addTag(String title) {
        tagDAO.saveAndFlush(Tag.builder()
                .title(title).build());
    }

    @Override
    public void deleteTagById(Long id) {
        tagDAO.delete(id);
    }
}
