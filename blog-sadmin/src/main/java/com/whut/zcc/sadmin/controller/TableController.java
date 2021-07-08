package com.whut.zcc.sadmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TableController {

    @GetMapping("/blogMan")
    public String basic_table(){
        return "table/basic_table";
    }

    @GetMapping("/typeMan")
    public String responsive_table(){
        return "table/responsive_table";
    }

    @GetMapping("/tagMan")
    public String editable_table(){
        return "table/editable_table";
    }
}

