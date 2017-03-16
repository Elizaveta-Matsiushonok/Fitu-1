package com.linoge.controllers.rest;

import com.linoge.models.shared.PdfBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Timo on 01.03.2017.
 */
@RestController
@RequestMapping("/")
public class PDFRestController {

    @RequestMapping(value = "/getpdf", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getPDF(@RequestParam("id") Long organisationId) throws Exception {
        return PdfBuilder.buildPDF();
    }
}
