package com.book.service;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.book.dao.BookDAO;
import com.book.domain.Book;
import com.book.domain.PageBean;

@Service
public class BookService {
    
    @Resource
    private BookDAO dao;
    
    public List<Book> getAllBooks(){
        return dao.selectAllBook();
    }
    public Book getBook(int id){
        return dao.selectBook(id);
    }
    public PageBean getBooksByPage(int currentPage,int currentNum) throws SQLException{        
        PageBean pb = new PageBean();
        List<Book> list = dao.selectBookByPage(currentPage, currentNum);
        int totalNum = dao.findCount();  //总条数
        int totalPage = (int) Math.ceil(totalNum*1.0/currentNum);
        pb.setCurrentPage(currentPage);
        pb.setCurrentNum(currentNum);
        pb.setList(list);
        pb.setTotalPage(totalPage);
        pb.setTotalNum(totalNum);
        return pb;
    }
    public void registerBook(Book book){
        dao.insertBook(book);
    }
    public void deleteBook(int id){
        dao.deleteBook(id);
    }
    public void updateBook(Book book,int id){
        dao.updateBook(book,id);
    }
  
}
