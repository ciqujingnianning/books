package com.book.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.book.domain.Book;
import com.book.domain.PageBean;
import com.book.service.BookService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Namespace("/")
@ParentPackage("struts-default")
@Action("/listBookAction")
@Results({
    @Result(name="success",location="/ListBooks.jsp")
})
public class ListBookAction extends ActionSupport{
    private static final long serialVersionUID = 1L;
    @Resource
    private BookService bookService;
   
    private List<Book> books;
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String execute() throws Exception {
       books = bookService.getAllBooks();
       return SUCCESS;
    }
}
