package com.book.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Book {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int bookId;
    private String bookName;
    private String bookType;
    private String author;
    private String discount;
    private float price;
    private int booknum;
    private String bookDesc;
    public Book() {
    }
    public Book(int bookId, String bookName, String bookType, String author, String discount, float price,
            int booknum, String bookDesc) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookType = bookType;
        this.author = author;
        this.discount = discount;
        this.price = price;
        this.booknum = booknum;
        this.bookDesc = bookDesc;
    }
    public Book(String bookName, String bookType, String author, String discount, float price,
            int booknum, String bookDesc) {
        this.bookName = bookName;
        this.bookType = bookType;
        this.author = author;
        this.discount = discount;
        this.price = price;
        this.booknum = booknum;
        this.bookDesc = bookDesc;
    }
    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getBookType() {
        return bookType;
    }
    public void setBookType(String bookType) {
        this.bookType = bookType;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getDiscount() {
        return discount;
    }
    public void setDiscount(String discount) {
        this.discount = discount;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    
    public int getBooknum() {
        return booknum;
    }
    public void setBooknum(int booknum) {
        this.booknum = booknum;
    }
    public String getBookDesc() {
        return bookDesc;
    }
    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc;
    }
    @Override
    public String toString() {
        return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookType=" + bookType + ", author="
                + author + ", discount=" + discount + ", price=" + price + ", booknum=" + booknum + ", bookDesc="
                + bookDesc + "]";
    }
    
}
