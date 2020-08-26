package com.anna.service;

import com.anna.entity.Book;
import com.anna.entity.Student;

import java.util.List;

public interface StudentService {
    void fillData();

    void addStudent(Student student);

    void updateStudent(Student student);

    List<Student> getAllStudents();

    void deleteStudent(Student student);

    Student getStudentById(int id);

    void addBook(int studentId, Book book);

    List<Book> showAllStudentBooks(int studentId);
}
