package test;

import org.junit.Test;
import pojo.Book;
import pojo.Page;
import service.BookService;
import service.impl.BookServiceimpl;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author 孟享广
 * @date 2020-10-19 4:17 下午
 * @description
 */
public class BookServiceTest {

    private BookService bookService = new BookServiceimpl();
    @Test
    public void addBook() {
        bookService.addBook(new Book(null, "新月最美", "广哥", new BigDecimal(999), 100, 0, null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(21);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(22, "新月最美!!", "广哥", new BigDecimal(999), 10000, 0, null));
    }

    @Test
    public void queryBookById() {
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookService.queryBooks();
        System.out.println(books);
    }
    
    @Test
    public void page(){
        System.out.println(bookService.page(1, Page.PAGE_SIZE));
        
    }
}