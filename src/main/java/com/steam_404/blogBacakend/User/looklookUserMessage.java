//author:steam-404
//查看用户留言
package com.steam_404.blogBacakend.User;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;

@RestController
public class looklookUserMessage {
    @CrossOrigin
    @RequestMapping("/userMessageList")
    public ArrayList<String> userMessageList() throws SQLException {
//        定义动态数组,传递用户的留言
        ArrayList<String> content = new ArrayList<String>();
        String url = "jdbc:mysql://localhost:3306/blog";
        String user = "root";
        String password = "root";
        String SQL = "select (content) from blog.messageboard;";
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL);
        while (resultSet.next()) {
            content.add(resultSet.getString("content"));
        }
        statement.close();
        connection.close();
        return content;
    }

}
