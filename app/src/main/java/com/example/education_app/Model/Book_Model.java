package com.example.education_app.Model;

public class Book_Model {
    int img_book;
    String book_name,witer,publisher,price,text_review;

    public Book_Model(int img_book, String book_name, String witer, String publisher, String price, String text_review) {
        this.img_book = img_book;
        this.book_name = book_name;
        this.witer = witer;
        this.publisher = publisher;
        this.price = price;
        this.text_review = text_review;
    }

    public int getImg_book() {
        return img_book;
    }

    public String getBook_name() {
        return book_name;
    }

    public String getWiter() {
        return witer;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getPrice() {
        return price;
    }

    public String getText_review() {
        return text_review;
    }
}
