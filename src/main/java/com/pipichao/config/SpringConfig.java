package com.pipichao.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
//@Import(MybatisConfig.class)//主动注入
//@ComponentScan("com.pipichao.config")//被动的扫描配置类
public class SpringConfig {
    /**
     *
     * 测试bean注入是否成功：注入成功
     * */
    @Bean(name = "myDate")
    public Date getDate(){
        try {
            Date date =new SimpleDateFormat("yyyy-MM-dd").parse("1949-10-01");
            return date;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
