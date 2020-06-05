package com.lmy.admin.controller;
/**
 * @Project admin
 * @Package com.lmy.admin.controller
 * @author Administrator
 * @date 2020/6/5 17:27
 * @version V1.0
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Administrator
 * @ClassName ApiController
 * @Description TODO
 * @date 2020/6/5 17:27
 **/
@Controller
@RequestMapping("${api-url}")
public class ApiController {

    @RequestMapping("/getPage")
    public ModelAndView getPage(ModelAndView model, String pageName) {
        model.setViewName(pageName);
        return model;
    }

}
