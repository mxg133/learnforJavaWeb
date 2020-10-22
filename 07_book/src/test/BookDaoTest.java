package test;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import org.junit.Test;
import pojo.Book;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author 孟享广
 * @date 2020-10-19 3:39 下午
 * @description
 */
public class BookDaoTest {
    BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null, "广哥真帅", "191125", new BigDecimal(999), 100, 0, null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(22);
    }

    @Test
    public void updateBook() {
        int book = bookDao.updateBook(new Book(21, "广哥真帅", "新月", new BigDecimal(999), 1100, 0, null));
        System.out.println(book);
    }

    @Test
    public void queryBookById() {
        Book book = bookDao.queryBookById(2);
        System.out.println(book);
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookDao.queryBooks();
        for (Book book: books) {
            System.out.println(book);
        }
    }

    @Test
    public void qureyForPageTotalCountByPrice() {
        System.out.println(bookDao.qureyForPageTotalCountByPrice(10, 50));
    }

    @Test
    public void qureyForPageItemsByprice() {
    }
}