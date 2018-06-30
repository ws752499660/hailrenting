package club.quan9.hailrenting.repository;

import club.quan9.hailrenting.domain.entity.Student;

public interface StudentRepository
{
    public Student findById(String id);
    public void save(Student student);
}
