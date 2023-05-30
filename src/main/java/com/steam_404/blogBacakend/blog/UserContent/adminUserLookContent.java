//author:steam-404
//后台查看用户留言
package com.steam_404.blogBacakend.blog.UserContent;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;

@RestController
public class adminUserLookContent {
    @CrossOrigin
    @RequestMapping(value = "/adminLookUserContent")
    public ArrayList<userContent> adminLookUserContent()throws SQLException{
        ArrayList<userContent> list=new ArrayList<>();
        String url="jdbc:mysql://localhost:3306/blog";
        String user="root";
        String password="root";
        String SQL="select * from blog.usercontent";
        Connection connection=DriverManager.getConnection(url,user,password);
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(SQL);
        while (resultSet.next()) {
            userContent usercontent=new userContent();
            usercontent.setRanking(resultSet.getInt("ranking"));
            usercontent.setDate(resultSet.getString("date"));
            usercontent.setTime(resultSet.getString("time"));
            usercontent.setContent(resultSet.getString("content"));
            list.add(usercontent);
        }
        return list;
    }
    public static class userContent {
        public int ranking;
        public String date;
        public String time;
        public String content;


        public void setRanking(int ranking) {
            this.ranking = ranking;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
