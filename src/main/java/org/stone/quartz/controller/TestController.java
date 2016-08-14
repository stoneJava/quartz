package org.stone.quartz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dslht on 2016/8/14.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/out")
    public void out(){
        System.out.println("test");
    }
}
