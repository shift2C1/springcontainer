package com.pipichao;

import com.pipichao.config.WebMvcConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class Application implements WebApplicationInitializer {
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext applicationContext=new AnnotationConfigWebApplicationContext();
        //指定springbean的配置路径
//        applicationContext.setConfigLocation();
//        applicationContext.setConfigLocations("com/pipichao/config/*");
        //mvc配置类
        applicationContext.register(WebMvcConfig.class);
        //必须有，不然没效果
        applicationContext.setServletContext(servletContext);
        applicationContext.refresh();
        //添加spring监听器
        servletContext.addListener(new ContextLoaderListener(applicationContext));

        //前置控制器
        DispatcherServlet dispatcherServlet=new DispatcherServlet();
        dispatcherServlet.setApplicationContext(applicationContext);
        //路劲通配符不可赔错，不然拦截不到请求
        servletContext.addServlet("dispatcherServlet",dispatcherServlet).addMapping("/app/*");

    }
}
