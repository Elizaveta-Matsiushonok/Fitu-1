package com.linoge.models.shared;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by Timo on 17.02.2017.
 */
@Service
public final class FileWorker {

    private static final String RELATIVE_PATH = "files/";

    public static void delete(Long id) throws FileNotFoundException {
        File file = new File(RELATIVE_PATH + id);
        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        } else {
            file.delete();
        }
    }
}
