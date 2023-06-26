package Dao;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;

//根据subject修改编号数据
@RestController
public class useJdbcUpdate {
    @CrossOrigin
//    处理跨域
    @RequestMapping(value = "update")
    public void update(
            @RequestParam int num1,
//            需要修改的字段
            @RequestParam int num2
//            修改的内容
    )throws SQLException{
        String url = "jdbc:mysql://localhost:3306/demo";
        String user = "root";
        String password = "root";
        String SQL="update demo.result set subjectNo = 100 where subjectNo = 1";
//        将subject为1的数值修改为100
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        statement.execute(SQL);
    }
}
