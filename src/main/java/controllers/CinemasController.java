package controllers;

import entities.Auditorium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import services.AuditoriumService;

import java.util.List;

/**
 * Created by Nikolay Shuvaev on 10.05.2017
 */
@Controller
@RequestMapping("/cinemas")
public class CinemasController {
    @Autowired
    private AuditoriumService auditoriumService;

    @GetMapping()
    public ModelAndView getCinemas() {
        List<Auditorium> all = auditoriumService.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cinemas");
        modelAndView.addObject("all_cinemas", all);
        return modelAndView;
    }
}
