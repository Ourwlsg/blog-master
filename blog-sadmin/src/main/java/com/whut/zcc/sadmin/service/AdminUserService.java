package com.whut.zcc.sadmin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import pers.fjl.common.po.User;

import java.util.List;


public interface AdminUserService extends IService<User> {
    List<User> getAllUsers();
}
