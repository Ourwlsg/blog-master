package com.whut.zcc.sadmin.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import pers.fjl.common.po.Blog;
import pers.fjl.common.vo.BlogVo;

import java.util.List;


@Repository
public interface AdminBlogDao extends BaseMapper<Blog> {

    @Select("SELECT * from blog")
    List<BlogVo> getAllBlogs();
}
