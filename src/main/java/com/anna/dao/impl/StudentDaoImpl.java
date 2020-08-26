package com.anna.dao.impl;

import com.anna.dao.StudentDao;
import com.anna.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public void addStudent(Student student) {
        getCurrentSession().persist(student);
    }


    @Override
    @Transactional
    public void updateStudent(Student student) {
        getCurrentSession().saveOrUpdate(student);
    }

    @Override
    @Transactional
    public List<Student> getAllStudents() {
        return getCurrentSession().createQuery("from Student", Student.class).list();
    }

    @Override
    @Transactional
    public void deleteStudent(Student student) {
        getCurrentSession().delete(student);
    }

    @Override
    @Transactional
    public Student getStudentById(int id) {
        return getCurrentSession().get(Student.class, id);
    }


    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
