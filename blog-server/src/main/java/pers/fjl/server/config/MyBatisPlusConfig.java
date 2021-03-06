package pers.fjl.server.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * <p>
 *  MP配置
 * </p>
 *
 * @author fangjiale
 * @since 2021-01-27
 */
@EnableTransactionManagement
@Configuration
public class MyBatisPlusConfig {

    // 已过期
    //    @Bean
    //    public PaginationInterceptor paginationInterceptor() {
    //        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
    //        paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
    //        return paginationInterceptor;
    //    }

//    @Bean
//    public MybatisPlusInterceptor mybatisPlusInterceptor(){
//        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
//        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();
//
//        // 设置请求的页面大于最大页后操作，true调回到首页，false 继续请求  默认false
//        paginationInnerInterceptor.setOverflow(true) ;
//        // 设置最大单页限制数量，默认50日条，-1不受限制
//        paginationInnerInterceptor.setMaxLimit(50L);
//        //开启count 的join优化，只针对部分left join
//        mybatisPlusInterceptor.addInnerInterceptor(paginationInnerInterceptor);
//        return mybatisPlusInterceptor;
//    }

    // 最新版
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

    //注册乐观锁
    @Bean
    public MybatisPlusInterceptor optimisticLockerInnerInterceptor(){
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return interceptor;
    }

}
