package com.wen.repository;

import com.wen.entity.Book;

import java.util.List;

public interface BookRepository {
    List<Book> findAll(int index, int limit);
    int count();
}
