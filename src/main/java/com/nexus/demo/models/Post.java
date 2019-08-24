package com.nexus.demo.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Post")
public class Post implements Serializable{

    private static final Long serialversionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String author;
    private String title;
    private String comment;

    public Post() {
    }

    public Post(String author, String title, String comment) {
        this.author = author;
        this.title = title;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
