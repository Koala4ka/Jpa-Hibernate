package com.anna.view.menu;

import com.anna.entity.Student;
import com.anna.service.StudentService;
import com.anna.view.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Scanner;

@Component
public class MainMenu implements Menu {
    private final Scanner SCANNER = new Scanner(System.in);
    private final String[] button = {"⓵ .Show students", "⓶.Find student",
            "⓷.add student", "⓸.update student", "⓹.delete student",
            "⓺.add book", "⓻.show student's books", "⓪ .Exit"};
    @Autowired
    StudentService studentService;
    private boolean inited = false;

    public void init() {
        studentService.fillData();
        inited = true;
    }

    @Override
    public void show() {
        if (!inited) {
            init();
        }
        System.out.println("Welcome to Student manager system");
        showButtons(button);
        switch (SCANNER.next()) {
            case "0" -> exit();
            case "1" -> showStudents();
            case "2" -> findStudent();
            case "3" -> addStudent();
            case "4" -> updateStudent();
            case "5" -> deleteStudent();
            case "6" -> addBook();
            case "7" -> showBooks();
            default -> incorrectInput();
        }
    }

    @Override
    public void exit() {
        System.exit(0);
    }

    private void showBooks() {
    }

    private void addBook() {
    }

    private void deleteStudent() {
        System.out.print("Enter user ID: ");
        Student student = studentService.getStudentById(SCANNER.nextInt());
        if (student != null) {
            studentService.deleteStudent(student);
            System.out.println("Student \"" + student.getFirstName() + "\" deleted");
        } else {
            System.out.println("Student not found");
        }
        show();
    }

    private void updateStudent() {

    }

    private void addStudent() {
        System.out.println("Add first name:");
        String firstName = SCANNER.next();
        System.out.println("Enter last name:");
        String lastName = SCANNER.next();
        System.out.println("Enter last email:");
        String email = SCANNER.next();
        studentService.addStudent(new Student(firstName, lastName, email));
        System.out.println("User successfully created");
        show();
    }

    private void findStudent() {
        System.out.println("Enter user id:");
        int id = SCANNER.nextInt();
        Student student = studentService.getStudentById(id);
        if (student == null) {
            System.out.println("User not found");
        } else {
            System.out.println("You've chosen " + student);
        }
        show();
    }

    private void showStudents() {
        int pageSize = 3;
        try {
            while (true) {
                System.out.println("Enter 0 to exit, enter page number to continue: ");
                int page = SCANNER.nextInt();
                if (page < 1) break;
                studentService.getAllStudents().stream().skip((page - 1) * pageSize)
                        .limit(pageSize)
                        .forEach(System.out::println);
            }
        } catch (InputMismatchException exception) {
            System.out.println("Wrong format, please try again");
        }
        show();
    }
}
