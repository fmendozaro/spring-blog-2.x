package com.codeup.springblog.models;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    @NotBlank(message = "Posts must have a title")
    private String title;
    @Size(min = 3, message = "A title must be at least 3 characters.")
    @NotBlank(message = "Posts must have a body")
    @Column(nullable = false, length = 100)
    private String body;

    @OneToOne
    private User user;

    // This one does not create a column
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="posts_categories",
            joinColumns={@JoinColumn(name="post_id")},
            inverseJoinColumns={@JoinColumn(name="category_id")}
    )
    private List<PostCategory> categories;

    public Post(){

    }

    // Constructor for everything for the R of (CRUD)
    public Post(long id, String title, String body, List<PostCategory> categories) {
        this.title = title;
        this.body = body;
        this.id = id;
        this.categories = categories;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public List<PostCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<PostCategory> categories) {
        this.categories = categories;
    }
}
