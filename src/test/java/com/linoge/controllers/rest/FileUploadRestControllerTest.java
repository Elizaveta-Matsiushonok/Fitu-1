package com.linoge.controllers.rest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContext;
import java.io.FileInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * Created by Tim on 19.02.2017.
 */
public class FileUploadRestControllerTest {

    private static final String PATH = "src/2.jpg";
    @Autowired
    ServletContext servletContext;

    @Test
    public void testphoto() throws Exception {
        InputStream in = new FileInputStream(PATH);
        assertTrue(in != null);
    }

}