package base.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author meng.wang09@hand-china.com 2020-09-27 17:38
 */
@RestController
public class AbcController {

    @RequestMapping("/test")
    public String hell0(){
        return "Hello world";
    }
}
