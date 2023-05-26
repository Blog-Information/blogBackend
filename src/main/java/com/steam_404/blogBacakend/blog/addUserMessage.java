package com.steam_404.blogBacakend.blog;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;

@RestController
public class addUserMessage {
    @CrossOrigin
    @RequestMapping("/addUserMessage")
//    访客添加留言功能
    public void addMessage(
            @RequestParam String timeStamp,
            @RequestParam int year,
            @RequestParam int month,
            @RequestParam int day,
            @RequestParam int hour,
            @RequestParam int minute,
            @RequestParam int second,
            @RequestParam String content
    ) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/blog";
        String user = "root";
        String password = "root";
        String SQL = "insert into blog.messageboard(timeStamp, year, month, day, hour, minute, second, content)" +
                " values ('" + timeStamp + "','" + year + "','" + month + "','" + day + "','" + hour + "','" + minute + "','" + second + "','" + content + "')";
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        statement.execute(SQL);
        statement.close();
        connection.close();
    }
}
