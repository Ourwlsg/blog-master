package com.whut.zcc.sadmin.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import pers.fjl.common.po.User;

import java.util.List;

@Repository
public interface AdminUserDao extends BaseMapper<User>{
}
