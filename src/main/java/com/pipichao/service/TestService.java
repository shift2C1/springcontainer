package com.pipichao.service;

import com.pipichao.dao.BaseCustomerDao;
import com.pipichao.entity.BaseCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TestService {
    @Autowired
    private BaseCustomerDao baseCustomerDao;
@Qualifier("myDate")@Autowired Date date;
    public String test(){
        System.out.println("testing service...");
//        BaseCustomer baseCustomer=baseCustomerDao.selectByPrimaryKey("KH20200317KH4");
//        return baseCustomer.toString();

        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }
}
