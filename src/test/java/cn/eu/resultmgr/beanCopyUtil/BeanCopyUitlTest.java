package cn.eu.resultmgr.beanCopyUtil;

import cn.eu.common.bean.BeanCopyUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class BeanCopyUitlTest {

    @Test
    @DisplayName("bean拷贝测试")
    void beanCopyTest(){
        Book book1=new Book("1","test");
        Book book11=new Book("11","test11");
        Book book12=new Book("12","test12");
        Book book13=new Book("13","test13");
        ArrayList<Book> ckBooks=new ArrayList<Book>();
        ckBooks.add(book11);
        ckBooks.add(book12);
        ckBooks.add(book13);
        book1.setCkbook(ckBooks);

        //Book copyBook= BeanCopyUtil.copy(book1,book1.getClass());
        //不成功
        Book cloneBook=(Book)book1.clone();
        Book copyBook=BeanCopyUtil.clone(book1);
        book1.setBookName("ichanged");
        book1.getCkbook().remove(book11);

        Assertions.assertEquals("test",cloneBook.getBookName());
        Assertions.assertEquals(cloneBook.getCkbook().size(),book1.getCkbook().size());

        Assertions.assertEquals("test",copyBook.getBookName());
        Assertions.assertNotEquals(copyBook.getCkbook().size(),book1.getCkbook().size());
        Assertions.assertEquals(3,copyBook.getCkbook().size());


    }

    @Test
    @DisplayName("list对象拷贝测试")
    void listCopyTest(){

        Book book11=new Book("11","test11");
        Book book12=new Book("12","test12");
        Book book13=new Book("13","test13");
        List<Book> ckBooks=new ArrayList<Book>();
        ckBooks.add(book11);
        ckBooks.add(book12);
        ckBooks.add(book13);
        //不成功
        List<Book> copyListBooks=BeanCopyUtil.clone(ckBooks);
        Assertions.assertEquals(3,copyListBooks.size());
    }

    @Test
    @DisplayName("set对象拷贝测试")
    void setCopyTest(){

        Book book11=new Book("11","test11");
        Book book12=new Book("12","test12");
        Book book13=new Book("13","test13");
        Set<Book> ckBooks=new HashSet<Book>();
        ckBooks.add(book11);
        ckBooks.add(book12);
        ckBooks.add(book13);
        Set<Book> copyListBooks=BeanCopyUtil.clone(ckBooks);
        book11.setBookName("changed!!!");

        Assertions.assertEquals(3,copyListBooks.size());
        Assertions.assertTrue(ckBooks.contains(book11));
        Assertions.assertFalse(copyListBooks.contains(book11));
    }

    @Test
    @DisplayName("map对象拷贝测试")
    void mapCopyTest(){

        Book book11=new Book("11","test11");
        Book book12=new Book("12","test12");
        Book book13=new Book("13","test13");
        Map<String,Book> ckBooks=new HashMap<String,Book>();
        ckBooks.put("11",book11);
        ckBooks.put("12",book12);
        ckBooks.put("13",book13);
        Map<String,Book> copyListBooks=BeanCopyUtil.clone(ckBooks);
        book11.setBookName("changed!!!");

        Assertions.assertEquals(3,copyListBooks.size());
        Assertions.assertTrue(copyListBooks.get("11").getBookName().equals("test11"));
        Assertions.assertTrue(ckBooks.get("11").getBookName().equals("changed!!!"));

    }

    @Test
    @DisplayName("null对象拷贝测试")
    void nullCopyTest(){

        Book book11=null;
        Book  copyListBook=BeanCopyUtil.clone(book11);

        Assertions.assertTrue(copyListBook==null);
    }
}
