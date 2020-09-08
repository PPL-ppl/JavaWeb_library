package com.wen.repository.RepositoryImpl;

import com.wen.Utils.JDBCUtils;
import com.wen.entity.Admin;
import com.wen.repository.AdminRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminRepositoryImpl implements AdminRepository {
    @Override
    public Admin login(String username, String password) {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        Admin admin=null;
        String sql = "select * from bookadmin where username=? and password=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                admin = new Admin(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(connection,statement,resultSet);
        }
        return admin;
    }
}
