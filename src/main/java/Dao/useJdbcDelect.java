package Dao;

import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//根据学号删除表数据
public class useJdbcDelect {
    public void deleteMessage(
            @RequestParam int num
//            根据编号删除表数据
    )throws SQLException {
        String url = "jdbc:mysql://localhost:3306/demo";
        String user = "root";
        String password = "root";
        String SQL = "truncate result";
//        整个表全删了吧
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        statement.execute(SQL);
    }
}
