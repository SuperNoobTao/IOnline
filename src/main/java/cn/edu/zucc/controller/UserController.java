package cn.edu.zucc.controller;

import cn.edu.zucc.model.UsertableBean;
import cn.edu.zucc.service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by shentao on 2016/5/28.
 */

@Controller
public class UserController {


    // 自动装配
    @Autowired
    private UserService userService;



    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("usertable") UsertableBean usertableBean) throws Exception {
        String studentNumber =usertableBean.getStudentName();
        String pwd = usertableBean.getPassword();
        usertableBean = userService.login(studentNumber,pwd);
        if(usertableBean != null){
        return "/showuser.jsp";}

        return "/login.jsp";
    }


}
