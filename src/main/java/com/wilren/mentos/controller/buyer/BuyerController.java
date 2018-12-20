package com.wilren.mentos.controller.buyer;

import com.wilren.mentos.common.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Wilren Chan
 * @version 1.0
 * @since 2018/10/12/012
 */
@Controller
@RequestMapping(value = "/buyer")
public class BuyerController extends BaseController {

    @RequestMapping(value = {"/", "index"})
    public String index() {
        return "index";
    }
}
