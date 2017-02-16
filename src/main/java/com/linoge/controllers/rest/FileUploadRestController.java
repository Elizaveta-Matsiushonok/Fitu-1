package com.linoge.controllers.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by Timo on 13.02.2017.
 */
@RestController
@RequestMapping("/")
public class FileUploadRestController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String handleFileUpload(MultipartHttpServletRequest request) {
        Iterator<String> itr = request.getFileNames();
        if (itr.hasNext()) {
            MultipartFile mpf = request.getFile(itr.next());
            System.out.println(mpf.getOriginalFilename() + " uploaded!");
            try {
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File("files/" +
                                mpf.getOriginalFilename())));
                stream.write(mpf.getBytes());
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "<img src='http://localhost:8081/files/" + mpf.getOriginalFilename() + "' />";
        }

        return "error";
    }
}
