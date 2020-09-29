package base.service;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.mts.springboot.dao.mapper.TestMapper;
import com.mts.springboot.feign.controller.TestControllerFeign;
import com.mts.springboot.feign.controller.TestRemoteControllerFeign;
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
public class Test1Service {

    @Autowired
    private TestControllerFeign testControllerFeign;
    @Autowired
    private TestMapper testMapper;
    @Autowired
    private TestRemoteControllerFeign testRemoteControllerFeign;

    @LcnTransaction
    @Transactional
    public void add(Test test) {
        testControllerFeign.add(test);
        test.setId(test.getId()+1);
        testRemoteControllerFeign.add(test);
        test.setId(test.getId()+1);
        testControllerFeign.add1(test);
        test.setId(test.getId()+1);
        testMapper.add(test);
        //int a=8/0;
    }
}
