package com.pipichao.dao;

import com.pipichao.entity.BaseCustomer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BaseCustomerDao {
    int deleteByPrimaryKey(String customerNo);

    int insert(BaseCustomer record);

    int insertSelective(BaseCustomer record);

    BaseCustomer selectByPrimaryKey(String customerNo);

    int updateByPrimaryKeySelective(BaseCustomer record);

    int updateByPrimaryKey(BaseCustomer record);
}