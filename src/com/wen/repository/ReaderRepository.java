package com.wen.repository;

import com.wen.entity.Reader;

public interface ReaderRepository {
    Reader login(String username, String password);
}
