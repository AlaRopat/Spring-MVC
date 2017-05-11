package controllers;

import dto.UserDTO;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import services.UserService;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
        modelAndView.setViewName("user/users");
        List<UserDTO> userDTOs = all.stream()
                .map(UserDTO::of)
                .collect(Collectors.toList());
        modelAndView.addObject("all_users", userDTOs);
        return modelAndView;
    }

    @GetMapping(path = "/add")
    public String addUserPage() {
        return "user/add_user";
    }

    @PostMapping(path = "/add")
    public String addUser(@RequestParam("name") String name, @DateTimeFormat(pattern = "yyyy-mm-dd") @RequestParam("birthday") Date birthday, @RequestParam("email") String email) {
        if (name == null) {
            return "redirect:/users/add?error=name";
        }
        if (birthday == null) {
            return "redirect:/users/add?error=birthday";
        }
        if (email == null) {
            return "redirect:/users/add?error=email";
        }

        long userId = userService.save(name, birthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), email);
        return "redirect:/users";
    }

    @GetMapping(path = "/{userId}")
    public ModelAndView showUser(@PathVariable("userId") Long id) {
        User user = userService.getById(id);
        ModelAndView modelAndView = new ModelAndView("user/show_user");
        modelAndView.addObject("user", UserDTO.of(user));
        return modelAndView;
    }

    @PostMapping(path = "/{userId}/delete")
    public String deleteUserSubmit(@PathVariable("userId") Long id) {
        userService.remove(id);
        return "redirect:/users";
    }

    @GetMapping(path = "/search")
    public String searchUser(@RequestParam("email") String email) {
        User user = userService.getUserByEmail(email.trim());
        if (user == null) {
            return "redirect:/users";
        }
        return "forward:/users/" + user.getId();
    }
}
