package com.steam_404.blogBacakend.blog.UserMessage;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@RestController
public class appendUserMessage {
    @CrossOrigin
    @RequestMapping("/appendVisitorMessage")
//    访客添加留言功能
    public void addMessage(
            @RequestParam String ipAddress,
            @RequestParam String country,
            @RequestParam String address,
            @RequestParam String lsp,
            @RequestParam String browser,
            @RequestParam String system
    ) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/blog";
        String user = "root";
        String password = "root";
        String SQL = "insert into blog.access(data, ipAddress, country, address, lsp, browser, `system`)\n" +
                "values (now(),'"+ipAddress+"','"+country+"','"+address+"','"+lsp+"','"+browser+"','"+system+"')";
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        statement.execute(SQL);
        statement.close();
        connection.close();
    }
}

