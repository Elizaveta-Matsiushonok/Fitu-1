package com.linoge.controllers.rest;

import com.linoge.models.dto.ImageDTO;
import com.linoge.servicies.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletContext;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static com.linoge.models.converters.ImageConverter.convertImageCollectionToDTO;
import static org.apache.commons.io.IOUtils.toByteArray;

/**
 * Created by Timo on 13.02.2017.
 */
@RestController
@RequestMapping("/")
public class FileUploadRestController {

    private static final String RELATIVE_PATH = "files/";

    @Autowired
    ImageService imageService;

    @Autowired
    ServletContext servletContext;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public List<ImageDTO> fileUpload(MultipartHttpServletRequest request) {
        return convertImageCollectionToDTO(imageService.uploadImages(request));
    }

    @Cacheable(value = "images", key = "#id")
    @RequestMapping(value = "/getimage", method = RequestMethod.GET)
    public byte[] getImage(@RequestParam("id") Long id) throws IOException {
        InputStream in = new FileInputStream(RELATIVE_PATH +
                imageService.getImageById(id).getName());
        byte[] image = toByteArray(in);
        in.close();
        return image;
    }
}
