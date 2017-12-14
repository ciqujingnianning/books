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
@Action("regBookAction")
@Results({
    @Result(name="success",location="/BookRegSucc.jsp"),
    @Result(name="input",location="/BookRegister.jsp")
})
public class RegBookAction extends ActionSupport{
    private static final long serialVersionUID = 1L;
    private String name;
    private String type;
    private String author;
    private String discount;
    private float price;
    private int booknum;
    private String desc;
    
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
    private Book book;
    public Book getBook() {
        return book;
    }
    @Override
    public String execute() throws Exception {
        book = new Book(name,type,author,discount,price,booknum,desc);
        bookService.registerBook(book);
        return SUCCESS;
    }
}
