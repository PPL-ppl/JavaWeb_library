package com.wen.service;

import com.wen.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll(int index);
    int getPages();
    void addBorreow(Integer bookid,Integer readerId);
}
