package com.linoge.controllers.rest;

import com.linoge.models.dto.ImageDTO;
import com.linoge.models.entities.Image;
import com.linoge.servicies.ImageService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static com.linoge.models.converters.ImageConverter.convertImageCollectionToDTO;

/**
 * Created by Timo on 13.02.2017.
 */
@RestController
@RequestMapping("/")
public class FileUploadRestController {

    @Autowired
    ImageService imageService;

    @Autowired
    ServletContext servletContext;



    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public List<ImageDTO> handleFileUpload(MultipartHttpServletRequest request) {
        return convertImageCollectionToDTO(imageService.uploadImages(request));
    }

    @RequestMapping(value = "/getimage", method = RequestMethod.GET)
    public byte[] testphoto() throws IOException {
        Image image = imageService.getImageById(16L);
        InputStream in = servletContext.getResourceAsStream(image.getName());
        return IOUtils.toByteArray(in);
    }
}
