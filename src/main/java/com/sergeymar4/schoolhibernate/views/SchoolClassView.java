package com.sergeymar4.schoolhibernate.views;

import com.sergeymar4.schoolhibernate.controllers.CourseController;
import com.sergeymar4.schoolhibernate.controllers.SchoolClassController;

import java.util.Scanner;

public class SchoolClassView {
    private String menuMessage;
    private SchoolClassController schoolClassController;
    private Scanner scanner;

    public SchoolClassView(Scanner scanner) {
        menuMessage = "Выбирите действие над Course\n" +
                "1.Вывести по id\n" +
                "2.Вывести список класса\n" +
                "3.Вывести список студентов с одинаковым именем\n" +
                "4.Добавить студента\n" +
                "5.Добавить курс\n" +
                "6.Создать\n" +
                "7.Обновить\n" +
                "8.Удалить\n" +
                "9.Выйти в главное меню";
        this.schoolClassController = new SchoolClassController();
        this.scanner = scanner;
    }

    public void show() {
        while (true) {

            System.out.println(menuMessage);
            String s = scanner.next();

            if (s.equals("1")) {
                System.out.println("Введите id класса = ");
                int id = scanner.nextInt();
                System.out.println(schoolClassController.getById(id));
            } else if (s.equals("2")) {
                System.out.println("Введите id класса = ");
                int id = scanner.nextInt();
                System.out.println(schoolClassController.getAll(id));
            } else if (s.equals("3")) {
                System.out.println("Введите id класса = ");
                int id = scanner.nextInt();
                System.out.println("Введите имя ученика = ");
                String firstName = scanner.next();
                System.out.println(schoolClassController.getStudentByFirstName(id, firstName));
            } else if (s.equals("4")) {
                System.out.println("Введите id класса = ");
                int school_id = scanner.nextInt();
                System.out.println("Введите id ученика = ");
                int student_id = scanner.nextInt();
                schoolClassController.addStudent(school_id, student_id);
            } else if (s.equals("5")) {
                System.out.println("Введите id класса = ");
                int school_id = scanner.nextInt();
                System.out.println("Введите id предмета = ");
                int course_id = scanner.nextInt();
                schoolClassController.addCourse(school_id, course_id);
            } else if (s.equals("6")) {
                System.out.println("Введите название класса = ");
                String title = scanner.next();
                schoolClassController.create(title);
            } else if (s.equals("7")) {
                System.out.println("Введите id класса = ");
                int id = scanner.nextInt();
                System.out.println("Введите название класса = ");
                String title = scanner.next();
                schoolClassController.update(id, title);
            } else if (s.equals("8")) {
                System.out.println("Введите id класса = ");
                int id = scanner.nextInt();
                schoolClassController.delete(id);
            } else {
                break;
            }
        }
    }
}
