package com.whut.zcc.sadmin.service.impl.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whut.zcc.sadmin.dao.AdminUserDao;
import com.whut.zcc.sadmin.service.AdminUserService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import pers.fjl.common.po.User;
import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserDao, User> implements AdminUserService {

    @Resource
    private AdminUserDao userDao;

    @Override
    public List<User> getAllUsers() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("uid", "username", "nickname","email", "avatar","create_time", "last_ip","data_status")
                .orderByAsc("create_time");
        return userDao.selectList(wrapper);
    }
}
