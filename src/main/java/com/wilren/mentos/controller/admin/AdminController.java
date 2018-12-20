package com.wilren.mentos.controller.admin;

import com.wilren.mentos.common.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Wilren Chan
 * @version 1.0
 * @since 2018/10/10/010
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController extends BaseController {

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String login(Model model, @RequestParam(value = "error", required = false) String error) {
        if (error != null) {
            model.addAttribute("error", "用户名或密码错误");
        }
        return "admin/login";
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/","/index"})
    public String index(Model model, @RequestParam(value = "error", required = false) String error) {
        return "admin/index";
    }


    @RequestMapping(method = RequestMethod.GET, value = {"/main"})
    public String main(Model model, @RequestParam(value = "error", required = false) String error) {
        return "admin/main";
    }
}
