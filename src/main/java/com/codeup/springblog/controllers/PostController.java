package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {

    public String index(Model vModel) {
        ArrayList<Post> consoles = new ArrayList<>();
        Post ps4 = new Post("ps4", "slightly used");
        Post switchNintendo = new Post("Nintendo Switch", "comes with Zelda");

        consoles.add(ps4);
        consoles.add(switchNintendo);

        vModel.addAttribute("posts", consoles);

        return "posts/index";
    }

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
