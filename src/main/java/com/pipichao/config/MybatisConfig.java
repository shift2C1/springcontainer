package com.pipichao.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
//@PropertySource("")//property配置文件
public class MybatisConfig {

    //数据源
//    @Bean(name = "myDataSource")

//参考地址 ：https://www.cnblogs.com/jhxxb/p/10512553.html
    //mybatis sql session
    @Bean
//    @DependsOn("myDataSource")//保证数据源先创建
    public SqlSessionFactoryBean getSqlSessionFactoryBean(){//spring 会自动找到数据源参数
        try {
            SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
            sqlSessionFactoryBean.setDataSource(getDateSource());
//        sqlSessionFactoryBean.setConfigLocation();//mybatis 全局配置文件

//        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));//mapper.xml 路径

            //mapper.xml 路径
            Resource[] resources=new PathMatchingResourcePatternResolver().getResources("com/pipichao/dao/*.xml");
            sqlSessionFactoryBean.setMapperLocations(resources);
            //包别名 不用写全类名
            sqlSessionFactoryBean.setTypeAliasesPackage("com.pipichao.entity");
            return sqlSessionFactoryBean;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
    @Bean
    public DruidDataSource getDateSource(){
        try {
            DruidDataSource druidDataSource=new DruidDataSource();
            druidDataSource.setUrl("jdbc:mysql://localhost:3306/syerp");

            druidDataSource.setDriver(new com.mysql.cj.jdbc.Driver());
            druidDataSource.setUsername("root");
            druidDataSource.setPassword("2437262431");
            return druidDataSource;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    //自动扫描mapper接口
    @Bean
    public MapperScannerConfigurer getMapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer=new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.pipichao");
//        mapperScannerConfigurer.setSqlSessionFactoryBeanName("mySqlSessionFactoryBean");
        return mapperScannerConfigurer;
    }
}
