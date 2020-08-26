package com.anna.dao;

import com.anna.entity.Student;

import java.util.List;

public interface StudentDao {
    void addStudent(Student student);

    void updateStudent(Student student);

    List<Student> getAllStudents();

    void deleteStudent(Student student);

    Student getStudentById(int id);

}
