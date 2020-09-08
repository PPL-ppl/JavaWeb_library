package com.wen.repository.RepositoryImpl;

import com.wen.Utils.JDBCUtils;
import com.wen.entity.Book;
import com.wen.entity.BookCase;
import com.wen.repository.BookRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {
    @Override
    public List<Book> findAll(int index, int limit) {
        List<Book> list = new ArrayList<>();
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Book book = null;
        BookCase bookCase = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select * from book b,bookcase ba where ba.id=b.bookcaseid limit ?,?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, index);
            statement.setInt(2, limit);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String author = resultSet.getString(3);
                String publish = resultSet.getString(4);
                int pages = resultSet.getInt(5);
                double price = resultSet.getDouble(6);
                int bId = resultSet.getInt(9);
                String bName = resultSet.getString(10);
                bookCase = new BookCase(bId, bName);
                book = new Book(id, name, author, publish, pages, price, bookCase);
                list.add(book);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.release(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public int count() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int count = 0;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select count(*) from book b,bookcase ba where ba.id=b.bookcaseid";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.release(connection, statement, resultSet);
        }
        return count;
    }
}
