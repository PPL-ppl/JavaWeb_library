package com.wen.service.serviceImpl;

import com.wen.entity.Book;
import com.wen.repository.BookRepository;
import com.wen.repository.BorreowRepository;
import com.wen.repository.RepositoryImpl.BookRepositoryImpl;
import com.wen.repository.RepositoryImpl.BorreowRepositoryImpl;
import com.wen.service.BookService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BookServiceImpl implements BookService {
    BookRepository bookRepository = new BookRepositoryImpl();
    BorreowRepository borreowRepository = new BorreowRepositoryImpl();
    private final int limit = 6;

    @Override
    public List<Book> findAll(int page) {
        int index = (page - 1) * limit;
        return bookRepository.findAll(index, limit);
    }

    @Override
    public int getPages() {
        int count = bookRepository.count();
        int page = 0;
        if (count % limit == 0) {
            page = count / limit;
        } else {
            page = count / limit + 1;
        }
        return page;
    }

    @Override
    public void addBorreow(Integer bookid, Integer readerId) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String borrowTime = dateFormat.format(date);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + 14);
        Date date2 = calendar.getTime();
        String returnTime = dateFormat.format(date2);
        borreowRepository.insert(bookid, readerId, borrowTime, returnTime, null, 0);
    }
}
