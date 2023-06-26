package Dao;

import org.springframework.web.bind.annotation.RequestParam;

import java.sql.*;

//jdbc对result实现添加数据
public class useJdbcAppend {
    public void appendMessage(
            @RequestParam int studentNO,
            @RequestParam int subjectNo,
            @RequestParam int studentResult
//            三个字段分别为学号 课程编号    考试成绩
    )throws SQLException {

        String url = "jdbc:mysql://localhost:3306/demo";
        String user = "root";
        String password = "root";
        String SQL = "insert into result(studentNo, subjectNo, studentResult)\n" +
                "        value (1,2,100)";
//        插入数据学号1，课程编号1，成绩100
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        statement.execute(SQL);
    }
}
