package com.wen.repository.RepositoryImpl;

import com.wen.Utils.JDBCUtils;
import com.wen.entity.Reader;
import com.wen.repository.ReaderRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReaderRepositoryImpl implements ReaderRepository {

    @Override
    public Reader login(String username, String password) {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        Reader reader=null;
        String sql = "select * from reader where username=? and password=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                reader = new Reader(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(connection,statement,resultSet);
        }
        return reader;
    }
}
