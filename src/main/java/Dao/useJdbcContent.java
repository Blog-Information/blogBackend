package Dao;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

import java.sql.*;

//使用jdbc连接数据库
@RestController
public class useJdbcContent {
    @CrossOrigin
//    处理跨域
    @RequestMapping(value = "jdbc")
    public void useJDBC() throws SQLException {
        System.out.println("使用jdbc连接数据库");
        String url = "jdbc:mysql://localhost:3306/demo";
        String user = "root";
        String password = "root";
        String SQL = "";
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet=statement.executeQuery(SQL);
        System.out.println(resultSet);
    }
}
