package com.sergeymar4.schoolhibernate.views;

import com.sergeymar4.schoolhibernate.controllers.CourseController;

import java.util.Scanner;

public class CourseView {
    private String menuMessage;
    private CourseController courseController;
    private Scanner scanner;

    public CourseView(Scanner scanner) {
        menuMessage = "Выбирите действие над Course\n" +
                        "1.Вывести по id\n" +
                        "2.Вывести весь список\n" +
                        "3.Создать\n" +
                        "4.Обновить\n" +
                        "5.Удалить\n" +
                        "6.Выйти в главное меню";
        this.courseController = new CourseController();
        this.scanner = scanner;
    }

    public void show() {
        while (true) {

            System.out.println(menuMessage);
            String s = scanner.next();

            if (s.equals("1")) {
                System.out.println("Введите id предмета = ");
                int id = scanner.nextInt();
                System.out.println(courseController.getById(id));
            } else if (s.equals("2")) {
                System.out.println(courseController.getAll());
            } else if (s.equals("3")) {
                System.out.println("Введите название предмета = ");
                String title = scanner.next();
                System.out.println("Введите id учителя = ");
                int teacher_id = scanner.nextInt();
                courseController.create(title, teacher_id);
            } else if (s.equals("4")) {
                System.out.println("Введите id предмета = ");
                int course_id = scanner.nextInt();
                System.out.println("Введите название предмета = ");
                String title = scanner.next();
                System.out.println("Введите id учителя = ");
                int teacher_id = scanner.nextInt();
                courseController.update(course_id, title, teacher_id);
            } else if (s.equals("5")) {
                System.out.println("Введите id предмета =");
                int id = scanner.nextInt();
                courseController.delete(id);
            } else {
                break;
            }
        }
    }
}
