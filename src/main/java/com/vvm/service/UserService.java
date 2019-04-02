package com.vvm.service;

import com.vvm.model.User;

public interface  UserService {
    /**
     * 删除
     */
    public void delete(int id);

    /**
     * 增加
     */
    public void insert(User user);

    /**
     * 更新
     */
    public int update(User user);

    /**
     * 查询单个
     */
    public User selectById(int id);


}
