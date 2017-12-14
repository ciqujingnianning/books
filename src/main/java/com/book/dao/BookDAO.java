package com.book.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.book.domain.Book;

@Repository
public class BookDAO {
    @Resource
    private HibernateTemplate hibernateTemplate;
    
    //插入数据
    public void insertBook(final Book book){
        hibernateTemplate.execute(new HibernateCallback<Book>() {

            public Book doInHibernate(Session session) throws HibernateException {
                session.save(book);
                return null;
            }
        });
    }
    
    //查询所有数据
    public List<Book> selectAllBook() {
        return hibernateTemplate.execute(new HibernateCallback() {

            @Override
            public Object doInHibernate(Session session) throws HibernateException {
                String hql = "from Book";
                Query query = session.createQuery(hql);
                List list = query.list();
                return list;
            }
        });
    }
    
    //分页查询
    public List<Book> selectBookByPage(final int currentPage,final int currentNum){
       return hibernateTemplate.execute(new HibernateCallback() {

            @Override
            public Object doInHibernate(Session session) throws HibernateException {
                String hql="from Book";
                Query query = session.createQuery(hql);
                query.setFirstResult((currentPage-1)*currentNum);
                query.setMaxResults(currentNum);
                List<Book> list = query.list();
                return list;
            }
        });
    }

  //查询所有的条数
    public int findCount(){
        return hibernateTemplate.execute(new HibernateCallback() {

            @Override
            public Object doInHibernate(Session session) throws HibernateException {
                String hql = "from Book";
                Query query = session.createQuery(hql);
                int num = query.list().size();
                return num;
            }
        });
    }
    
    //根据ID查询数据
    public Book selectBook(int id){
        return hibernateTemplate.get(Book.class, id);
    }
    
    //删除数据
    public void deleteBook(final int id){
        hibernateTemplate.execute(new HibernateCallback() {

            @Override
            public Object doInHibernate(Session session) throws HibernateException {
                String hql = "delete from Book where bookid = ?";
                Query query = session.createQuery(hql);
                query.setInteger(0, id);
                query.executeUpdate();
                return null;
            }
        });
    }
    
    
    //更新数据
    public void updateBook(final Book book, final int id) {
        hibernateTemplate.execute(new HibernateCallback<Book>() {
           
            @Override
            public Book doInHibernate(Session session) throws HibernateException {
                String hql = "update Book set bookName=?,bookType=?,author=?,discount=?,price=?,booknum=?,bookDesc=? where bookid=?";
                Query query = session.createQuery(hql);
                query.setString(0, book.getBookName());
                query.setString(1, book.getBookType());
                query.setString(2, book.getAuthor());
                query.setString(3, book.getDiscount());
                query.setFloat(4, book.getPrice());
                query.setInteger(5, book.getBooknum());
                query.setString(6, book.getBookDesc());
                query.setInteger(7, id);
                query.executeUpdate();
                return null;
            }
        });
    }
    
}
