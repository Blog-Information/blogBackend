package com.steam_404.blogBacakend.blog.UserContent;

import org.springframework.web.bind.annotation.*;

import java.sql.*;

@RestController
public class appendUserContent {
    @CrossOrigin
    @RequestMapping(value = "/appendContent")
//    访客添加留言功能
    public void addMessage(
            @RequestParam String content
    ) throws SQLException {
        System.out.println(content);
        String url = "jdbc:mysql://localhost:3306/blog";
        String user = "root";
        String password = "root";
        String SQL = "insert into blog.usercontent(date, time, content)  \n" +
                "values(now(),now(),'"+content+"')";
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        statement.execute(SQL);
        statement.close();
        connection.close();
    }
}