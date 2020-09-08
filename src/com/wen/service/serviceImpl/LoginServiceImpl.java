package com.wen.service.serviceImpl;

import com.wen.entity.Reader;
import com.wen.repository.AdminRepository;
import com.wen.repository.ReaderRepository;
import com.wen.repository.RepositoryImpl.AdminRepositoryImpl;
import com.wen.repository.RepositoryImpl.ReaderRepositoryImpl;
import com.wen.service.LoginService;

public class LoginServiceImpl implements LoginService {
    ReaderRepository readerRepository = new ReaderRepositoryImpl();
    AdminRepository adminRepository = new AdminRepositoryImpl();

    @Override
    public Object login(String username, String password, String type) {
        Object object = null;
        switch (type) {
            case "reader":
                object = readerRepository.login(username, password);
                break;
            case "admin":
                object = adminRepository.login(username, password);
                break;
            default:
                break;
        }
        return object;
    }
}
