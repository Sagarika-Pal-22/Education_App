package com.example.education_app.Model;

public class Favourite_Model {
    String img_fav,book_name,writer,publisher,price;

    public Favourite_Model(String img_fav, String book_name, String writer, String publisher, String price) {
        this.img_fav = img_fav;
        this.book_name = book_name;
        this.writer = writer;
        this.publisher = publisher;
        this.price = price;
    }

    public String getImg_fav() {
        return img_fav;
    }

    public String getBook_name() {
        return book_name;
    }

    public String getWriter() {
        return writer;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getPrice() {
        return price;
    }
}
