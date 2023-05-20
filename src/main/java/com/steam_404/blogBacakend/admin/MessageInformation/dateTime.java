//author:steam-404
//用户留言日期(时间戳)
package com.steam_404.blogBacakend.admin.MessageInformation;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;

@RestController
public class dateTime {
    @CrossOrigin
    @GetMapping(value = "/MessageInformationDateTime")
    public ArrayList<String> userContentDate() throws SQLException {
        ArrayList<String> list=new ArrayList<String>();
        String url="jdbc:mysql://localhost:3306/blog";
        String user="root";
        String password="root";
        String SQL="select (timeStamp) from messageboard;";
        Connection connection= DriverManager.getConnection(url,user,password);
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(SQL);
        while (resultSet.next()) {
            list.add(resultSet.getString("timeStamp"));
        }
        return list;
    }
}
