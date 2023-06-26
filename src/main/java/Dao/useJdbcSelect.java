package Dao;

import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.*;

//使用jdbc查询subject表数据
@RestController
public class useJdbcSelect {
    @CrossOrigin
    @RequestMapping(value = "lookSubject")
    public ArrayList<subject> subjectArrayList() throws SQLException {
        ArrayList<subject> subjectArrayList = new ArrayList<subject>();
        String url = "jdbc:mysql://localhost:3306/demo";
        String user = "root";
        String password = "root";
        String SQL = "select * from subject";
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL);
        while (resultSet.next()) {
            subject subject = new subject();
            int subjectNo = resultSet.getInt("subjectNo");
            String subjectName = resultSet.getString("subjectName");
            int classHour=resultSet.getInt("classHour");
            int gradeID=resultSet.getInt("gradeID");
            subject.setSubjectNo(subjectNo);
            subject.setSubjectName(subjectName);
            subject.setClassHour(classHour);
            subject.setGradeID(gradeID);
            subjectArrayList.add(subject);
        }
        return subjectArrayList;
    }


    public static class subject {
        int subjectNo;
        String subjectName;
        int classHour;
        int gradeID;

        public void setSubjectNo(int subjectNo) {
            this.subjectNo = subjectNo;
        }

        public void setSubjectName(String subjectName) {
            this.subjectName = subjectName;
        }

        public void setClassHour(int classHour) {
            this.classHour = classHour;
        }

        public void setGradeID(int gradeID) {
            this.gradeID = gradeID;
        }
    }
}