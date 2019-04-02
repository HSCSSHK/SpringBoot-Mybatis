package com.vvm.controller;

import com.vvm.model.User;
import com.vvm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/delete/{id}")
    public void delete(@PathVariable("id") int id) {
        userService.delete(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/insert")
    public void insert(User user) {
        userService.insert(user);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update/{id}")
    public void update(@RequestParam User user) {
        userService.update(user);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/select")
    public User select(@PathVariable("id") int id) {
        return userService.selectById(id);
    }

}
