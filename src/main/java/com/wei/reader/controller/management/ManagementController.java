package com.wei.reader.controller.management;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author wei
 * @date 2021/10/26 21:23
 * @description: 后台系统控制器
 */
@Controller
@RequestMapping("/management")
public class ManagementController {

    @GetMapping("/index.html")
    public ModelAndView showIndex() {
        return new ModelAndView("/management/index");
    }
}
