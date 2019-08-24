package com.nexus.demo.dtos;

public class PostDTO {

    private String author;
    private String title;
    private String comment;

    public PostDTO() {
    }

    public PostDTO(String author, String title, String comment) {
        this.author = author;
        this.title = title;
        this.comment = comment;
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
}
