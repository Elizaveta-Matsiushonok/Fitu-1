package com.linoge.servicies.implementations;

import com.linoge.dao.ImageDAO;
import com.linoge.models.entities.Image;
import com.linoge.models.shared.FileWorker;
import com.linoge.servicies.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;
import static java.util.stream.Collectors.toList;

/**
 * Created by Timo on 17.02.2017.
 */
@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    ImageDAO imageDAO;

    @Autowired
    FileWorker imageWriter;


    @Override
    public List<Image> uploadImages(MultipartHttpServletRequest request) {
        return imageDAO.save(imageWriter.upload(request).stream()
                .map(name -> Image.builder()
                        .name(name)
                        .build())
                .collect(toList()));
    }

    @Override
    public Image getImageById(Long i) {
        return imageDAO.getOne(i);
    }


}
