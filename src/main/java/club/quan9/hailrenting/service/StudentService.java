package club.quan9.hailrenting.service;

import club.quan9.hailrenting.domain.entity.Student;

public interface StudentService
{
    public Student login(String id,String password);
    public String setId(Student student);
    public void save(Student student);
}