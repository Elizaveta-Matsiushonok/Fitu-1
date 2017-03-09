package com.linoge.models.shared;

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
public final class FileWorker {

    private static final String RELATIVE_PATH = "files/";

    public static void delete(String fileName) throws FileNotFoundException {
        File file = new File(RELATIVE_PATH + fileName);
        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        } else {
            file.delete();
        }
    }

    public static String nameToHashCodeInString(String name) {
        return Integer.toString(name.hashCode());
    }


    public List<String> upload(MultipartHttpServletRequest request) {
        List<String> result = new ArrayList<>();
        Iterator<String> itr = request.getFileNames();
        while (itr.hasNext()) {
            MultipartFile mpf = request.getFile(itr.next());
            try {
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(RELATIVE_PATH +
                                nameToHashCodeInString(mpf.getOriginalFilename()))));
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
