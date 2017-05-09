package controllers;

import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import services.UserService;

import java.time.LocalDate;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getHelloWorld() {
        long id = userService.save("Test", LocalDate.of(1999, 11, 11), "hello@mail.ru");
        User returnedById = userService.getById(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", returnedById);
        modelAndView.setViewName("helloTest");
        return modelAndView;
    }
}
