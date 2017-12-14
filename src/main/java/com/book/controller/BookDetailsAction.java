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

@Controller
@Namespace("/")
@ParentPackage("struts-default")
@Action("bookDetailsAction")
@Results({
    @Result(name="success",location="/BookDetails.jsp")
})
public class BookDetailsAction extends ActionSupport{
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Resource
    private BookService bookService;
    private Book book;
    
    public Book getBook() {
        return book;
    }
    @Override
    public String execute() throws Exception {
       book = bookService.getBook(id);
       return SUCCESS;
    }
}
