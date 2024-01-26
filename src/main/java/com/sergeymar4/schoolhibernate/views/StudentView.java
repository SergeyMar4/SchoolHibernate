package com.sergeymar4.schoolhibernate.views;

import com.sergeymar4.schoolhibernate.controllers.CourseController;
import com.sergeymar4.schoolhibernate.controllers.StudentController;

import java.util.Scanner;

public class StudentView {
    private String menuMessage;
    private StudentController studentController;
    private Scanner scanner;

    public StudentView(Scanner scanner) {
        menuMessage = "Выбирите действие над Course\n" +
                "1.Вывести по id\n" +
                "2.Вывести весь список\n" +
                "3.Создать\n" +
                "4.Обновить\n" +
                "5.Удалить\n" +
                "6.Выйти в главное меню";
        this.studentController = new StudentController();
        this.scanner = scanner;
    }

    public void show() {
        while (true) {

            System.out.println(menuMessage);
            String s = scanner.next();

            if (s.equals("1")) {
                System.out.println("Введите id ученика = ");
                int id = scanner.nextInt();
                System.out.println(studentController.getById(id));
            } else if (s.equals("2")) {
                System.out.println(studentController.getAll());
            } else if (s.equals("3")) {
                System.out.println("Введите id класса = ");
                int id = scanner.nextInt();
                System.out.println("Введите имя ученика = ");
                String firstName = scanner.next();
                System.out.println("Введите фамилию ученика = ");
                String lastName = scanner.next();
                System.out.println("Введите возраст ученика = ");
                int age = scanner.nextInt();
                studentController.create(id, firstName, lastName, age);
            } else if (s.equals("4")) {
                System.out.println("Введите id ученика = ");
                int student_id = scanner.nextInt();
                System.out.println("Введите id класса = ");
                int id = scanner.nextInt();
                System.out.println("Введите имя ученика = ");
                String firstName = scanner.next();
                System.out.println("Введите фамилию ученика = ");
                String lastName = scanner.next();
                System.out.println("Введите возраст ученика = ");
                int age = scanner.nextInt();
                studentController.update(student_id, id, firstName, lastName, age);
            } else if (s.equals("5")) {
                System.out.println("Введите id ученика = ");
                int id = scanner.nextInt();
                studentController.delete(id);
            } else {
                break;
            }
        }
    }
}
