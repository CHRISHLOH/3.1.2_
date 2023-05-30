package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    public String carModel2(Model model) {
        model.addAttribute("users", userService.getUserList());
        return "users";
    }

    @GetMapping("/{id}")
    public String userById(@PathVariable("id") int id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "user";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") @Valid User user,
                             BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "/new";

        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult, @PathVariable("id") int id){
        if(bindingResult.hasErrors())
            return "/edit";
        userService.updateUser(id, user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        userService.deleteUser(id);
        return "redirect:/";
    }


}
