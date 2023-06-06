package com.steam_404.blogBacakend.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {
    @RequestMapping(value = "test1")
    public String test1() {
        return "接口完全ojbk";
    }

    @RequestMapping(value = "test2")
    public String test2() {
        return "test2也完全ojbk";
    }

    @RequestMapping(value = "test3")
    public String test3() {
        return "test3也完全ojbk";
    }

    @RequestMapping(value = "tes4")
    public String test4() {
        return "test4也完全ojbk";
    }

    @RequestMapping(value = "test5")
    public String test5() {
        return "test5也完全ojbk";
    }

}
