package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    private long count;
    @RequestMapping(path = "/add/{number1}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String addInputs(@PathVariable long number1, @PathVariable long number2){
        count = number1 + number2;
        return "Your numbers added together is " + count;
    }

    @RequestMapping(path = "/subtract/{number1}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String subtractInputs(@PathVariable long number1, @PathVariable long number2){
        count = number1 - number2;
        return "Your numbers subtracted is " + count;
    }

    @RequestMapping(path = "/multiply/{number1}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String multiplyInputs(@PathVariable long number1, @PathVariable long number2){
        count = number1 * number2;
        return "Your numbers multiplied together is " + count;
    }

    @RequestMapping(path = "/divide/{number1}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String divideInputs(@PathVariable long number1, @PathVariable long number2){
        count = number1 / number2;
        return "Your numbers divided is " + count;
    }
}
