package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @PostMapping("/posts")
    @ResponseBody
    public String thePosts(){
        return "Here are the posts";
    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String postsID(int id){
        return "Here are the posts with IDs";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost(){
        return "Form to create a post";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String getCreatePost(){
        return "Submitted form to create a post";
    }
}
