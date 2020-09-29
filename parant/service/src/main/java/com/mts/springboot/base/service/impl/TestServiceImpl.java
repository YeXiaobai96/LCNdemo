package com.mts.springboot.base.service.impl;

import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.mts.springboot.base.service.TestService;
import com.mts.springboot.dao.mapper.TestMapper;
import com.mts.springboot.model.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Filename: TestServiceImpl
 * @Author: wm
 * @Date: 2019/9/3 9:14
 * @Description:
 * @History:
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;
    @Override
    public List<Test> list() {
        List<Test> list=testMapper.list();
        return list;
    }

    @LcnTransaction
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int add(Test test) throws Exception{
        int b=testMapper.add(test);
        //int a=8/0;
        //throw new RuntimeException("test");
        return b;
    }

    @LcnTransaction(propagation = DTXPropagation.SUPPORTS)
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT )
    @Override
    public int add1(Test test) {
        int b=testMapper.add(test);
        int a=8/0;
        return b;
    }
}
