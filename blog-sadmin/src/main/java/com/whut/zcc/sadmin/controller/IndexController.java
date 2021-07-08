package com.whut.zcc.sadmin.controller;

import com.whut.zcc.sadmin.bean.AdminUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class IndexController {
    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String main(AdminUser adminUser, HttpSession session, Model model){

//        if(!StringUtils.isEmpty(adminUser.getUsername()) && "".equals(adminUser.getPassword())){
//            session.setAttribute("loginUser", adminUser);
//            //重定向到main.html 避免重复提交表单
//            return "redirect:/main.html";
//        }else {
//            model.addAttribute("msg","账号密码错误");
//            return "login";
//        }
        session.setAttribute("loginUser", adminUser);
        return "redirect:/main.html";

    }

    //避免重复提交表单
    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model){
        Object loginUser = session.getAttribute("loginUser");
        if(loginUser != null){
            return "main";
        }else {
            model.addAttribute("msg", "请登录");
            return "login";
        }

    }
}
