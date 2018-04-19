package com.mytest.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @RequestMapping("/")
    @ResponseBody
    public String hello(){
        System.out.println("你大爷 ");
        System.out.println("你大爷 ");
        System.out.println("你大爷 ");
        System.out.println("你大爷 ");
        return "hello spring boot";
    }
}
