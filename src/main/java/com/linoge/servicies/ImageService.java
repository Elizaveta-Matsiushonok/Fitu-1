package com.linoge.servicies;

import com.linoge.models.entities.Image;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

/**
 * Created by Timo on 17.02.2017.
 */
public interface ImageService {
    List<Image> uploadImages(MultipartHttpServletRequest request);

    Image getImageById(Long i);
}
