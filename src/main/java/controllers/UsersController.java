package controllers;

import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import services.UserService;

import java.util.List;
import java.util.Map;

/**
 * Created by Nikolay Shuvaev on 10.05.2017
 */
@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public ModelAndView getAllUsers() {
        List<User> all = userService.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        modelAndView.addObject("all_users", all);
        return modelAndView;
    }

    @GetMapping(path = "/add")
    public String addUserPage() {
        return "add_user";
    }

    @PostMapping(path = "/add")
    public String addUser(@RequestBody Map<String, String> params, BindingResult result, Model model) {
//        userService.save()
        System.out.println("post");
        return "users";
    }
}
