package com.wen.repository.RepositoryImpl;

import com.wen.Utils.JDBCUtils;
import com.wen.repository.BorreowRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BorreowRepositoryImpl implements BorreowRepository {
    @Override
    public void insert(Integer bookid, Integer readerid, String borrowTime, String returnTime, Integer adminid, Integer state) {
        Connection connection = null;
        PreparedStatement statement = null;
        connection = JDBCUtils.getConnection();
        String sql = "insert into borrow(bookid,readerid,borrowtime,returntime,state) value(?,?,?,?,0)";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, bookid);
            statement.setInt(2, readerid);
            statement.setString(3, borrowTime);
            statement.setString(4, returnTime);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.release(connection, statement, null);
        }
    }
}
