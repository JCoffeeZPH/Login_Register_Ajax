package com.demo.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by ForMe
 * com.demo.utils
 * 2019/1/11
 * 13:57
 */
public class JdbcUtils {
    private static String URL = null;
    private static String USER = null;
    private static String PASS = null;
    private static String DRIVER = null;

    static{
        Properties p = new Properties();
        InputStream in = JdbcUtils.class.getResourceAsStream("/a.properties");
        try {
            p.load(in);
            URL = p.getProperty("url");
            USER = p.getProperty("user");
            PASS = p.getProperty("password");
            DRIVER = p.getProperty("driver");
            Class.forName(DRIVER);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() throws SQLException {
        Connection connection = DriverManager.getConnection(URL,USER,PASS);
        return connection;
    }

    public static void close(Connection connection , PreparedStatement preparedStatement) throws SQLException {
        if(connection != null)
            connection.close();
        if(preparedStatement != null)
            preparedStatement.close();
    }

    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) throws SQLException {
        if(connection != null)
            connection.close();
        if(preparedStatement != null)
            preparedStatement.close();
        if(resultSet != null)
            resultSet.close();
    }
}
