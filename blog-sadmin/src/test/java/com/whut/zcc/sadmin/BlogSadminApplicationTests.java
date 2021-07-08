package com.whut.zcc.sadmin;

import com.whut.zcc.sadmin.dao.AdminBlogDao;
import com.whut.zcc.sadmin.dao.AdminUserDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
@Slf4j
class BlogSadminApplicationTests {

//    @Autowired
//    JdbcTemplate jdbcTemplate;
//
//    @Test
//    void contextLoads() {
//
//        //        jdbcTemplate.queryForObject("select * from account_tbl")
//        //        jdbcTemplate.queryForList("select * from account_tbl",)
//        Long aLong = jdbcTemplate.queryForObject("select count(*) from `blog-extension`.blog", Long.class);
//        log.info("记录总数：{}",aLong);
//    }
    @Autowired
    AdminBlogDao adminBlogDao;

    @Test
    void testMybatisPlus(){
//        System.out.println(adminBlogDao.getAllBlogs());
        System.out.println(adminBlogDao.selectById(1356935614018834433L));
    }
}

