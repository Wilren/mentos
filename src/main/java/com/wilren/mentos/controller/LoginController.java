package com.wilren.mentos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Wilren Chan
 * @version 1.0
 * @since 2018/10/10/010
 */
@Controller
@RequestMapping(value = "")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String login(Model model, @RequestParam(value = "error", required = false) String error) {
        if (error != null) {
            model.addAttribute("error", "用户名或密码错误");
        }
        return "login";
    }


}
