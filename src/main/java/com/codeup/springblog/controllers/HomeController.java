package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String landingPage(){
        return "<h1>This is the landing page</h1>";
    }
    @GetMapping("/roll-dice")
    public String rollDice(){
        return "roll-dice";
    }
    @RequestMapping (path = "/roll-dice/1")
    public String rolledDice1(){
        return "roll-dice/1";
    }
    @RequestMapping (path = "/roll-dice/2")
    public String rolledDice2(){
        return "roll-dice/2";
    }
    @RequestMapping (path = "/roll-dice/3")
    public String rolledDice3(){
        return "roll-dice/3";
    }
    @RequestMapping (path = "/roll-dice/4")
    public String rolledDice4(){
        return "roll-dice/4";
    }
    @RequestMapping (path = "/roll-dice/5")
    public String rolledDice5(){
        return "roll-dice/5";
    }
    @RequestMapping (path = "/roll-dice/6")
    public String rolledDice6(){
        return "roll-dice/6";
    }
}
