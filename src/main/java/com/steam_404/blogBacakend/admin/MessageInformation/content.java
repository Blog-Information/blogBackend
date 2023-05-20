//author:steam-404
//查询用户留言信息
package com.steam_404.blogBacakend.admin.MessageInformation;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import java.sql.*;

@RestController
public class content {

    @CrossOrigin
    @GetMapping(value = "/MessageInformationContent")
    public ArrayList<String> userContent()throws SQLException{
        ArrayList<String> list=new ArrayList<String>();
        String url="jdbc:mysql://localhost:3306/blog";
        String user="root";
        String password="root";
        String SQL="select (content) from messageboard;";
        Connection connection=DriverManager.getConnection(url,user,password);
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(SQL);
        while (resultSet.next()) {
            list.add(resultSet.getString("content"));
        }
        return list;
    }
}
