package com.sergeymar4.schoolhibernate.views;

import com.sergeymar4.schoolhibernate.controllers.CourseController;
import com.sergeymar4.schoolhibernate.controllers.TeacherController;

import java.util.Scanner;

public class TeacherView {
    private String menuMessage;
    private TeacherController teacherController;
    private Scanner scanner;

    public TeacherView(Scanner scanner) {
        menuMessage = "Выбирите действие над Course\n" +
                "1.Вывести по id\n" +
                "2.Вывести весь список\n" +
                "3.Добавить предмет\n" +
                "4.Создать\n" +
                "5.Обновить\n" +
                "6.Удалить\n" +
                "7.Выйти в главное меню";
        this.teacherController = new TeacherController();
        this.scanner = scanner;
    }

    public void show() {
        while (true) {

            System.out.println(menuMessage);
            String s = scanner.next();

            if (s.equals("1")) {
                System.out.println("Введите id учителя = ");
                int id = scanner.nextInt();
                System.out.println(teacherController.getById(id));
            } else if (s.equals("2")) {
                System.out.println(teacherController.getAll());
            } else if (s.equals("3")) {
                System.out.println("Введите id учителя = ");
                int teacher_id = scanner.nextInt();
                System.out.println("Введите id предмета = ");
                int course_id = scanner.nextInt();
                teacherController.addCourse(teacher_id, course_id);
            } else if (s.equals("4")) {
                System.out.println("Введите имя учителя = ");
                String firstName = scanner.next();
                System.out.println("Введите фамилию учителя = ");
                String lastName = scanner.next();
                System.out.println("Ввелите возраст учителя = ");
                int age = scanner.nextInt();
                teacherController.create(firstName, lastName, age);
            } else if (s.equals("5")) {
                System.out.println("Введите id учителя = ");
                int id = scanner.nextInt();
                System.out.println("Введите имя учителя = ");
                String firstName = scanner.next();
                System.out.println("Введите фамилию учителя = ");
                String lastName = scanner.next();
                System.out.println("Ввелите возраст учителя = ");
                int age = scanner.nextInt();
                teacherController.update(id, firstName, lastName, age);
            } else if (s.equals("6")) {
                System.out.println("Введите id учителя = ");
                int id = scanner.nextInt();
                teacherController.delete(id);
            } else {
                break;
            }
        }
    }
}
