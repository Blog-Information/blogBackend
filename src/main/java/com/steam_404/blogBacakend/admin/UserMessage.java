package com.steam_404.blogBacakend.admin;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;

@RestController
public class UserMessage {
    @CrossOrigin
//    返回数据库的访客
    @RequestMapping(value = "/visitor")
    public ArrayList<User> visitorMessage() throws SQLException {
        ArrayList<User> list = new ArrayList<>();

        String url = "jdbc:mysql://localhost:3306/blog";
        String user = "root";
        String password = "root";
        String SQL = "select * from access;";
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL);
        while (resultSet.next()) {
            User userMessage = new User();
            userMessage.setRanking(resultSet.getInt("ranking"));
            userMessage.setData(String.valueOf(resultSet.getDate("data")));
            userMessage.setIpAddress(resultSet.getString("ipAddress"));
            userMessage.setAddress(resultSet.getString("address"));
            userMessage.setLsp(resultSet.getString("lsp"));
            userMessage.setBrowser(resultSet.getString("browser"));
            userMessage.setSystem(resultSet.getString("system"));
            list.add(userMessage);
        }
        return list;
    }

    public static class User {
        public int ranking;
        public String data;
        public String ipAddress;
        public String address;
        public String lsp;
        public String browser;
        public String system;

        public int getRanking() {
            return ranking;
        }

        public void setRanking(int ranking) {
            this.ranking = ranking;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public String getIpAddress() {
            return ipAddress;
        }

        public void setIpAddress(String ipAddress) {
            this.ipAddress = ipAddress;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getLsp() {
            return lsp;
        }

        public void setLsp(String lsp) {
            this.lsp = lsp;
        }

        public String getBrowser() {
            return browser;
        }

        public void setBrowser(String browser) {
            this.browser = browser;
        }

        public String getSystem() {
            return system;
        }

        public void setSystem(String system) {
            this.system = system;
        }
    }
}