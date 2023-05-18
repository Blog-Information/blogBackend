//author:steam-404
//毒鸡汤接口
package com.steam_404.blogBacakend.recordedUtterance;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import java.sql.*;
import java.util.Random;

@RestController
public class PoisonousChickenSoup {
    //    允许跨域
    //    随机输出毒鸡汤语录
    @CrossOrigin
    @GetMapping(value = "/jitang")
    public String jitang() throws SQLException{
        ArrayList<String> list= new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/blog";
        String user = "root";
        String password = "root";
        String SQL = "SELECT * FROM chickensoup;";
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet=statement.executeQuery(SQL);
        while (resultSet.next()) {
            list.add(resultSet.getString("value"));
        }
        Random random= new Random();

        statement.close();
        connection.close();
        return list.get(random.nextInt(list.size()));
    }
}
