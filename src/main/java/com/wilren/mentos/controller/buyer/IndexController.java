package com.wilren.mentos.controller.buyer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Wilren Chan
 * @version 1.0
 * @since 2018/10/19/019
 */
@Controller
@RequestMapping(value = "")
public class IndexController {
    @RequestMapping(value = {"/", "index"})
    public String index() {
        return "index";
    }
}
