package cn.eu.resultmgr.beanCopyUtil;

import java.io.Serializable;
import java.util.List;

public class Book implements Cloneable, Serializable {
    private String bookID;

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public List<Book> getCkbook() {
        return ckbook;
    }

    public void setCkbook(List<Book> ckbook) {
        this.ckbook = ckbook;
    }

    private String bookName;
    private List<Book> ckbook;
    Book(String bookid, String bookname){
        bookID=bookid;
        bookName=bookname;
    }
    public Object clone() {
        Book book = null;
        try{
            book = (Book)super.clone();
            }catch(CloneNotSupportedException e) {
            e.printStackTrace();
            }
        return book;
    }
}
