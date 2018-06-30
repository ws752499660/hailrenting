package club.quan9.hailrenting.repository.impl;

import club.quan9.hailrenting.domain.entity.Student;
import club.quan9.hailrenting.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository
{
    @Autowired
    JdbcTemplate jdbcTemplate;

    private String SQL_FIND="select name,addr,tel,birthday,gender,id,password " +
            "from student where id=?";

    private String SQL_SAVE="INSERT INTO student(name, addr,tel,birthday,gender,id,password)" +
            "VALUES (?,?,?,?,?,?,?)";

    @Override
    public Student findById(String id)
    {
        final List<Student> list=new ArrayList<Student>();
        jdbcTemplate.query(SQL_FIND, new Object[]{id}, new RowCallbackHandler()
        {
            @Override
            public void processRow(ResultSet rs) throws SQLException
            {
                Student student=new Student();
                student.setName(rs.getString("name"));
                student.setAddr(rs.getString("addr"));
                student.setTel(rs.getString("tel"));
                student.setBirthday(rs.getInt("birthday"));
                student.setGender(rs.getString("gender"));
                student.setId(rs.getString("id"));
                student.setPassword(rs.getString("password"));
                list.add(student);
            }
        });
        if(list.size()>0)
            return list.get(0);
        else
            return null;
    }

    @Override
    public void save(Student student)
    {
        jdbcTemplate.update(SQL_SAVE,student.getName(),student.getAddr(),student.getTel(),
                student.getBirthday(),student.getGender(),student.getId(),student.getPassword());
    }
}
