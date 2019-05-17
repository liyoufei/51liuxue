package com.sss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * SchoolController class
 *
 * @author Sss
 * @date 2019/4/3
 */

@Controller
@RequestMapping(value = "/school")
public class SchoolController {


    @RequestMapping(value = "/ranking")
    public String ranking(){
        return "colleges-ranking";
    }
}
