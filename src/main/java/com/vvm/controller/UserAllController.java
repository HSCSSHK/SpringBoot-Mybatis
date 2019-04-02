package com.vvm.controller;

import com.github.pagehelper.PageInfo;
import com.vvm.model.PageResult;
import com.vvm.model.User;
import com.vvm.service.UserAllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/alluser")
public class UserAllController {
    @Autowired
    private UserAllService userAllService;
    @RequestMapping(method = RequestMethod.GET, value = "/selectAll")
    public List<User> selectAll() {
        return userAllService.selectAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/selectAllUser/{pageNum}/{pageSize}")
    public PageResult<List<User>> selectAll(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {

        return userAllService.selectAll(pageNum, pageSize);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/selectPageUser/{pageNum}/{pageSize}")
    public PageInfo<User> selectPageAll(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {

        return userAllService.selectPageAll(pageNum, pageSize);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/selectById/{id}")
    public User selectById(@PathVariable("id") int id) {

        return userAllService.selectById(id);
    }
}
