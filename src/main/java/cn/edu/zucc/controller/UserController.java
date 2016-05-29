package cn.edu.zucc.controller;

import cn.edu.zucc.model.UsertableBean;
import cn.edu.zucc.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by shentao on 2016/5/28.
 */

@Controller
public class UserController {


    // 自动装配
    @Autowired
    private UserRepository userRepository;





    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@ModelAttribute("usertable") UsertableBean userEntity, HttpSession httpSession){
        System.out.println(userEntity.getStudentNumber());
        System.out.println(userEntity.getPassword());
        UsertableBean ue = userRepository.findByUP(userEntity.getStudentNumber(), userEntity.getPassword());
        if (ue != null) {
            ue.setPassword("");
            httpSession.setAttribute("usertable", ue);
            return "showuser";
        }else{
            return "index";
        }
    }


}
