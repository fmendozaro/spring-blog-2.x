package com.codeup.springblog.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="categories")
public class PostCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "categories")
    private List<Post> posts;

    public PostCategory() {
    }

    public PostCategory(long id, String name, List<Post> posts) {
        this.name = name;
        this.posts = posts;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setAds(List<Post> posts) {
        this.posts = posts;
    }
}
