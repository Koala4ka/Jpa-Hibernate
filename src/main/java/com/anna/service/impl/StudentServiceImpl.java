package com.anna.service.impl;

import com.anna.dao.StudentDao;
import com.anna.entity.Student;
import com.anna.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;

    @Override
    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }

    @Override
    @Transactional
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }


    @Override
   public void deleteStudent(Student student){
         studentDao.deleteStudent(student);
    }

    @Override
    public Student getStudentById(int id) {
        return studentDao.getStudentById(id);
    }

    public void fillData() {
        addStudent(new Student("Jessica", "Parker", "parker@mail.com"));
        addStudent(new Student("Jerry", "Smith", "smith@mail.com"));
        addStudent(new Student("Anna", "Salem", "salem@mail.com"));
        addStudent(new Student("Sara", "Butcher", "sara@mail.com"));
        addStudent(new Student("Kiki", "Ghost", "kiki@mail.com"));
        addStudent(new Student("Linda", "Farm", "farm@mail.com"));
        addStudent(new Student("Michael", "Pork", "porky@mail.com"));
    }
}

