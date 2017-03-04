package com.linoge.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Timo on 01.03.2017.
 */

@Controller
public class PDFController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(@RequestParam(value = "name", required = false, defaultValue = "World")
                               String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }

    @RequestMapping("/downloadPDF")
    public ModelAndView downloadPDF() {
        return new ModelAndView("pdfView");
    }

    @RequestMapping("/references")
    public String references() {
        return "references";
    }
}
