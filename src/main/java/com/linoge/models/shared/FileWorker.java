package com.linoge.models.shared;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletContext;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Timo on 17.02.2017.
 */
@Service
public final class FileWorker {

    private final String RELATIVE_PATH = "files/";

    public static void delete(String nameFile) throws FileNotFoundException {
        exists(nameFile);
        new File(nameFile).delete();
    }

    private static void exists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }
    }

    public List<String> upload(MultipartHttpServletRequest request) {
        List<String> result = new ArrayList<>();
        Iterator<String> itr = request.getFileNames();
        while (itr.hasNext()) {
            MultipartFile mpf = request.getFile(itr.next());
            try {
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(RELATIVE_PATH +
                                mpf.getOriginalFilename())));
                stream.write(mpf.getBytes());
                stream.close();
                result.add(mpf.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
