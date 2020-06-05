package com.lmy.admin.controller;
/**
 * @Project admin
 * @Package com.lmy.admin.controller
 * @author Administrator
 * @date 2020/6/5 17:14
 * @version V1.0
 */

import com.lmy.admin.entity.TbUser;
import com.lmy.admin.service.TbUserService;
import com.lmy.admin.vo.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Administrator
 * @ClassName IndexController
 * @Description 控制器
 * @date 2020/6/5 17:14
 **/
@Controller
public class IndexController {

    @Autowired
    private TbUserService tbUserServiceImpl;

    @GetMapping("/")
    public String index() {
        return "index";
    }


    @GetMapping("user/list")
    @ResponseBody
    public Results<TbUser> getUserList() {
        List<TbUser> tbUsers = tbUserServiceImpl.selectUserList();
        return Results.success("success",10000, tbUsers);
    }

}
