package com.pipichao.handler;

import com.pipichao.dao.BaseCustomerDao;
import com.pipichao.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class TestController {
//    @Autowired
//    @Qualifier("myDate")
//    private Date data;

//    @Autowired
//    BaseCustomerDao baseCustomerDao;

    @Autowired
    private TestService testService;

    @RequestMapping("test")
    @ResponseBody
    public String test(){
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(data));
//        baseCustomerDao.selectByPrimaryKey("KH1001");
        String s=testService.test();
        return s;
    }
}
