package com.wen.service;

import com.wen.entity.Reader;

public interface LoginService {
    Object login(String username,String password,String type);
}
