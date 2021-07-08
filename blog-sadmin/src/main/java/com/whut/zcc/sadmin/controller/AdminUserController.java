package com.whut.zcc.sadmin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whut.zcc.sadmin.service.AdminUserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pers.fjl.common.po.User;

import javax.annotation.Resource;

@Controller
public class AdminUserController {

    @Resource
    AdminUserService adminUserService;

    @GetMapping("/userMan")

    public String getAllUsers(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model){
        //  查询全部
        //  List<User> page = adminUserService.list();
        Page<User> userPage = new Page<User>(pn, 6);
        Page<User> page = adminUserService.page(userPage, null);
        model.addAttribute("page",page);
        return "/table/users";
    }

    @GetMapping("/userMan/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,
                             @RequestParam(value = "pn", defaultValue = "1") Integer pn,
                             RedirectAttributes ra){
        adminUserService.removeById(id);
        ra.addAttribute("pn", pn);
        return "redirect:/userMan";
    }

    @PostMapping("/userMan/add")
    public String addUser(User user) {
        adminUserService.save(user);
        return "redirect:/userMan";
    }
}