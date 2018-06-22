package com.gmail.madkiev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mveselov on 6/22/2018.
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public String handleRequest () {
        return "index.html";
    }
}
