package com.example.education_app.Adapter;

public class LbraryHistory_Model {

    String img_books,accesion,book_name,book_id,issue_date;

    public LbraryHistory_Model(String img_books, String accesion, String book_name, String book_id, String issue_date) {
        this.img_books = img_books;
        this.accesion = accesion;
        this.book_name = book_name;
        this.book_id = book_id;
        this.issue_date = issue_date;
    }

    public String getImg_books() {
        return img_books;
    }

    public String getAccesion() {
        return accesion;
    }

    public String getBook_name() {
        return book_name;
    }

    public String getBook_id() {
        return book_id;
    }

    public String getIssue_date() {
        return issue_date;
    }
}
