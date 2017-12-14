package com.book.controller;


import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.book.domain.PageBean;
import com.book.service.BookService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Namespace("/")
@ParentPackage("struts-default")
@Action("listBookPageAction")
@Results({
    @Result(name="success",location="/listBookPage.jsp")
})
public class ListBookPageAction extends ActionSupport{
    private static final long serialVersionUID = 1L;
    @Resource
    private BookService bookService;
    private int currentPage;
    private int currentNum;
    public int getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public int getCurrentNum() {
        return currentNum;
    }
    public void setCurrentNum(int currentNum) {
        this.currentNum = currentNum;
    }
    private PageBean pb;
    public PageBean getPb() {
        return pb;
    }
    
    @Override
    public void validate() {
        if(currentPage == 0){
            currentPage = 1;
        }
        if(currentNum == 0){
            currentNum = 5;
        }
    }
    @Override
    public String execute() throws Exception {
        pb = bookService.getBooksByPage(currentPage, currentNum);
        return SUCCESS;
    }
}
