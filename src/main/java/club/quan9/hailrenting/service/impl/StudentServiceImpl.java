package club.quan9.hailrenting.service.impl;

import club.quan9.hailrenting.domain.entity.Student;
import club.quan9.hailrenting.repository.StudentRepository;
import club.quan9.hailrenting.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService
{
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student login(String id, String password)
    {
        Student student=studentRepository.findById(id);
        if(student != null && student.getPassword().equals(password))
            return student;
        else
            return null;
    }

    @Override
    public String setId(Student student)
    {
        String str = String.valueOf(student.getBirthday());
        str = str.substring(0, 6);
        str = str+student.getGender();
        return str;
    }

    @Override
    public void save(Student student)
    {
        studentRepository.save(student);
    }
}
