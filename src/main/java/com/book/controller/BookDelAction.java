package com.book.controller;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.book.service.BookService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Namespace("/")
@ParentPackage("struts-default")
@Action("bookDelAction")
@Results({
    @Result(name="success",location="/delSucc.jsp")
})
public class BookDelAction extends ActionSupport{
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Resource
    private BookService bookService;
    @Override
    public String execute() throws Exception {
        bookService.deleteBook(id);
        return SUCCESS;
    }
}
