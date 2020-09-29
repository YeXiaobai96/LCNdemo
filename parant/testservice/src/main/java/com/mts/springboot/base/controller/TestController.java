package com.mts.springboot.base.controller;

import com.mts.springboot.base.service.TestService;
import com.mts.springboot.model.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;


/**
 * @Filename: TestController
 * @Author: wm
 * @Date: 2019/9/2 15:44
 * @Description:
 * @History:
 */
@ApiIgnore
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "test/list",method = RequestMethod.GET)
    public Object list(HttpServletRequest request){
        return testService.list();
    }

    @RequestMapping(value = "test/add",method = RequestMethod.POST)
    public Object add(@RequestBody Test test) throws Exception{
        return testService.add(test);
    }

    @RequestMapping(value = "test/add1",method = RequestMethod.POST)
    public Object add1(@RequestBody Test test){
        return  testService.add1(test);
    }


}
