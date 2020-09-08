package com.wen.repository;

public interface BorreowRepository {
    void insert(Integer bookid,Integer readerid,String borrowTime,String returnTime,Integer adminid,Integer state);
}
