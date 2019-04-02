package com.vvm.service;

import com.github.pagehelper.PageInfo;
import com.vvm.model.PageResult;
import com.vvm.model.User;

import java.util.List;

public interface UserAllService {
    /**
     * 查询全部列表
     */
    public List<User> selectAll();

    public PageResult<List<User>> selectAll(Integer pageNum, Integer pageSize);

    public PageInfo<User> selectPageAll(Integer pageNum, Integer pageSize);

    public User selectById(int id);
}
