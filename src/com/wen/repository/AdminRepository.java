package com.wen.repository;

import com.wen.entity.Admin;

public interface AdminRepository {
    Admin login(String username, String password);
}
