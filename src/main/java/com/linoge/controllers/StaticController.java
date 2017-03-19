package com.linoge.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Evgeniy Romanovich on 13.03.2017.
 */
@Controller
public class StaticController {

    @ModelAttribute("faculty")
    @RequestMapping(value="/faculty", method= RequestMethod.GET)
    public String faculty(){
        return "faculty";
    }

    @ModelAttribute("index")
    @RequestMapping(value="/index", method= RequestMethod.GET)
    public String index(){
        return "index";
    }

    @ModelAttribute("achievements")
    @RequestMapping(value="/achievements", method = RequestMethod.GET)
    public String achievements(){return "achievements";}

    @ModelAttribute("abiturient")
    @RequestMapping(value="/abiturient", method = RequestMethod.GET)
    public String abiturient(){return "abiturient";}

    @ModelAttribute("help")
    @RequestMapping(value="/help", method = RequestMethod.GET)
    public String help(){return "help";}
}
