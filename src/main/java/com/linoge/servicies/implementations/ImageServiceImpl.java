package com.linoge.servicies.implementations;

import com.linoge.dao.ImageDAO;
import com.linoge.models.entities.Image;
import com.linoge.models.shared.FileWorker;
import com.linoge.servicies.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Timo on 17.02.2017.
 */
@Service
public class ImageServiceImpl implements ImageService {

    private static final String RELATIVE_PATH = "files/";
    @Autowired
    ImageDAO imageDAO;

    @Autowired
    FileWorker imageWriter;

    @Override
    public List<Image> uploadImages(MultipartHttpServletRequest request) {
        List<Long> result = new ArrayList<>();
        Iterator<String> itr = request.getFileNames();
        while (itr.hasNext()) {
            MultipartFile mpf = request.getFile(itr.next());
            try {
                Long id = imageDAO.save(new Image()).getId();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(RELATIVE_PATH +
                                id)));
                stream.write(mpf.getBytes());
                stream.close();
                result.add(id);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return imageDAO.findAll(result);
    }

    @Override
    public Image getImageById(Long id) {
        return imageDAO.getOne(id);
    }

    @Override
    public void deleteImageById(Long id) {
        try {
            FileWorker.delete(id);
            imageDAO.delete(id);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
