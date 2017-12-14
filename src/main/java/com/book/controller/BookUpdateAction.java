package com.book.controller;


import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.book.domain.Book;
import com.book.service.BookService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.DoubleRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;

@Controller
@Namespace("/")
@ParentPackage("struts-default")
@Action("bookUpdateAction")
@Results({
    @Result(name="success",location="/BookUpdateSucc.jsp"),
    @Result(name="input",location="/BookUpdate.jsp")
})
public class BookUpdateAction extends ActionSupport{
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String type;
    private String author;
    private String discount;
    private float price;
    private int booknum;
    private String desc;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    @RequiredStringValidator(key="name.error.null",trim=true,shortCircuit=true)
    @StringLengthFieldValidator(key="name.error.len",trim=true,minLength="2",maxLength="10")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    @RequiredStringValidator(key="author.error.null",trim=true)
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
    @DoubleRangeFieldValidator(key="price.error.range",minInclusive="20.00",maxInclusive="50.00")
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    @IntRangeFieldValidator(key="booknum.error.range",min="10",max="50")
    public int getBooknum() {
        return booknum;
    }
    public void setBooknum(int booknum) {
        this.booknum = booknum;
    }
    @RequiredStringValidator(key="desc.error.null",trim=true,shortCircuit=true)
    @StringLengthFieldValidator(key="desc.error.len",trim=true,minLength="10",maxLength="100")
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    @Resource
    private BookService bookService;
    @Override
    public String execute() throws Exception {
        Book book = new Book(id,name,type,author,discount,price,booknum,desc);
        bookService.updateBook(book, id);
        return SUCCESS;
    }
}
