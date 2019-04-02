package com.vvm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vvm.mapper.UserAllMaper;
import com.vvm.model.PageResult;
import com.vvm.model.User;
import com.vvm.service.UserAllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserAllServicelmpl implements UserAllService {
    @Autowired
    private UserAllMaper userAllMaper;
    /**
     * 查询全部列表,并做分页 * * @param pageNum 开始页数 * @param pageSize 每页显示的数据条数
     */
    @Override
    public List<User> selectAll() { //将参数传给这个方法就可以实现物理分页了，非常简单。

         return userAllMaper.selectUserAll();
    }
    @Override
    public PageResult<List<User>> selectAll(Integer  pageNum, Integer  pageSize) {
         //将参数传给这个方法就可以实现物理分页了，非常简单。

         PageHelper.startPage(pageNum,pageSize);
         final List<User> users =  userAllMaper.selectUserAll();
         final PageInfo pageInfo = new PageInfo(users);

          //PageHelper.clearPage();

          final PageResult<List<User>> pageResult = PageResult.sucessOf(users);
          pageResult.setPageNumber(pageNum);
          pageResult.setPageSize(pageSize);
          pageResult.setPageTotal(pageInfo.getTotal());
          return pageResult;
    }

    @Override
    public PageInfo<User> selectPageAll(Integer  pageNum, Integer  pageSize) {
         System.out.println("selectPageAll ---  pageNum="+pageNum+";pageSize="+pageSize);
        PageHelper.startPage(pageNum,pageSize);
        List<User> UserList = userAllMaper.selectUserAll();
        PageInfo<User> pageInfo = new PageInfo<User>(UserList);
        return pageInfo;

    }

    @Override
    public User selectById(int  id) {

        User UserList = userAllMaper.selectByPrimaryKey(id);

        return UserList;

    }
}
