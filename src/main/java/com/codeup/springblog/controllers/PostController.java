package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.Post;
import com.codeup.springblog.repos.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postRepository){
        postDao = postRepository;
    }

    @GetMapping("/posts")
    public String index(Model vModel) {
        Iterable<Post> posts = postDao.findAll();
        vModel.addAttribute("posts", posts);
        return "ads/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model viewModel) {
        Post post = postDao.findOne(id);
        viewModel.addAttribute("post", post);
        return "ads/show";
    }

    @GetMapping("/posts/search")
    public String show(@RequestParam(name = "term") String term, Model viewModel) {
        List<Post> posts = postDao.searchByTitleLike(term);
        viewModel.addAttribute("posts", posts);
        return "ads/index";
    }

    @GetMapping("/posts/{id}/edit")
    public String edit(@PathVariable long id, Model viewModel) {
        Post post = postDao.findOne(id);
        viewModel.addAttribute("post", post);
        return "ads/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String update(@PathVariable long id,
                         @RequestParam(name = "title") String title,
                         @RequestParam(name = "description") String description,
                         Model viewModel) {
        Post postToBeUpdated = postDao.findOne(id);
        postToBeUpdated.setTitle(title);
        postToBeUpdated.setDescription(description);
        postDao.save(postToBeUpdated);
        return "redirect:/posts/" + postToBeUpdated.getId();
    }

    @PostMapping("/posts/{id}/delete")
    public String delete(@PathVariable long id){
        postDao.delete(id);
        return "redirect:/posts";
    }
//    @GetMapping("/posts/create")
//    @ResponseBody
//    public String createPostForm() {
//        return "Please fill out this form";
//    }
//
////    POST	/posts/create	create a new post
//    @PostMapping("/posts/create")
//    @ResponseBody
//    public String createPost() {
//        return "Great new Post";
//    }
}