package com.whut.zcc.sadmin.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisConfig {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();

        // 设置请求的页面大于最大页后操作，true调回到首页，false 继续请求  默认false
        paginationInnerInterceptor.setOverflow(true) ;
        // 设置最大单页限制数量，默认50日条，-1不受限制
         paginationInnerInterceptor.setMaxLimit(50L);
        //开启count 的join优化，只针对部分left join
        mybatisPlusInterceptor.addInnerInterceptor(paginationInnerInterceptor);
        return mybatisPlusInterceptor;
    }
}
