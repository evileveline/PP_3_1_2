package web.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.MyUser;
import web.service.CustomUserDetailsService;
import web.service.UserServiceImpl;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    private final UserServiceImpl userServiceImpl;

    private final CustomUserDetailsService customUserDetailsService;


    public UserController(UserServiceImpl userServiceImpl, CustomUserDetailsService customUserDetailsService) {
        this.userServiceImpl = userServiceImpl;
        this.customUserDetailsService = customUserDetailsService;
    }

    @GetMapping
    public String user(Model model) {
        MyUser myUser = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = myUser.getId();
        myUser = userServiceImpl.getUserById(userId);
        model.addAttribute("user", myUser);
        return "user";
    }
}