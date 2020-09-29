package com.mts.springboot.apifeign.service;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.mts.springboot.feign.controller.TestControllerFeign;
import com.mts.springboot.model.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Filename: TestService
 * @Author: wm
 * @Date: 2019/9/24 11:15
 * @Description:
 * @History:
 */
@Service
public class TestService {

    @Autowired
    private TestControllerFeign testControllerFeign;

    @LcnTransaction
    @Transactional
    public void add(Test test) {
        testControllerFeign.add(test);
        test.setId(test.getId()+1);
        testControllerFeign.add1(test);
    }
}
