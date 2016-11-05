package by.epam.gamerportal.controller;

import by.epam.gamerportal.persistance.to.Section;
import by.epam.gamerportal.service.impl.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

/**
 * Created by Yayheniy_Lepkovich on 11/3/2016.
 */

@RestController
public class SectionRestController {
    @Autowired
    SectionService sectionService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Section> readSections(){
        return sectionService.getAll();
    }

    @RequestMapping("/")
    public ModelAndView index(){
        Section section = sectionService.findById(2);
        return new ModelAndView("index");
    }

}
