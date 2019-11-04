package com.jz.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jz
 * @date 2019/11/4 - 21:43
 */
@Controller
public class StudyController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("food")
    public String getFood() {
        return "food";
    }

    @RequestMapping("about")
    public String getAbout() {
        return "about";
    }

    @RequestMapping("profile")
    public String getProfile() {
        return "profile";
    }

    @RequestMapping("/403")
    public String getErr() {
        return "403";
    }

}
