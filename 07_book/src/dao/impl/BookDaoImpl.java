package dao.impl;

import dao.BookDao;
import pojo.Book;

import java.util.List;

/**
 * @author 孟享广
 * @date 2020-10-19 2:13 下午
 * @description
 */
public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book(`name` , `author` , `price` , `sales` , `stock` , `img_path`) values(?,?,?,?,?,?)";
        int i = update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath());
        return i;
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "DELETE FROM t_book WHERE id = ?";
        int i = update(sql, id);
        System.out.println("已经删除 " + i + " 本书····");
        return i;

    }

    @Override
    public int updateBook(Book book) {
        String sql = "UPDATE t_book SET `name`=? , `author`=? , `price`=? , `sales`=? , `stock`=? , `img_path` = ? WHERE id = ?";
        int i = update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath(), book.getId());
        return i;
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "SELECT `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath FROM t_book where id = ?";
        Book book = queryForOne(Book.class, sql, id);
        return book;
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "SELECT `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath FROM t_book";
        List<Book> books = queryForList(Book.class, sql);
        return books;
    }
}
