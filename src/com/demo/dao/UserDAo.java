package com.demo.dao;

import com.demo.bean.User;
import com.demo.utils.JdbcUtils;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ForMe
 * com.demo.dao
 * 2019/1/11
 * 14:15
 */
public class UserDAo {
    public boolean isRegister(String username) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from user where name=?";
        try {
            connection = JdbcUtils.getConn();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JdbcUtils.close(connection,preparedStatement,resultSet);
        }
        return true;
    }

    public void register(String username,String password) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
       // ResultSet resultSet = null;
        String sql = "insert into user(name,password) values(?,?)";
        try {
            connection = JdbcUtils.getConn();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection,preparedStatement);
        }
    }
}
