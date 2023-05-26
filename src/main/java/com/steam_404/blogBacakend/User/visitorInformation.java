//访客信息
package com.steam_404.blogBacakend.User;

import org.springframework.web.bind.annotation.*;

import java.sql.*;
@RestController
public class visitorInformation {
    @CrossOrigin
    @GetMapping(value = "visitorMessage")
    public void visitorMessage(
            @RequestParam String ipAddress,
            @RequestParam String address,
            @RequestParam String lsp,
            @RequestParam String browser,
            @RequestParam String system
    )throws SQLException{
        String url="jdbc:mysql://localhost:3306/blog";
        String user="root";
        String password="root";
        String SQL="insert into access(data, ipAddress, address, lsp, browser, `system`)\n" +
                "VALUES (now(),'"+ipAddress+"','"+address+"','"+lsp+"','"+browser+"','"+system+"')";
        Connection connection=DriverManager.getConnection(url,user,password);
        Statement statement=connection.createStatement();
        statement.execute(SQL);
    }
}
