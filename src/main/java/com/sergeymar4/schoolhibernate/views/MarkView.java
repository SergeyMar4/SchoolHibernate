package com.sergeymar4.schoolhibernate.views;

import com.sergeymar4.schoolhibernate.controllers.CourseController;
import com.sergeymar4.schoolhibernate.controllers.MarkController;

import java.util.Scanner;

public class MarkView {
    private String menuMessage;
    private MarkController markController;
    private Scanner scanner;

    public MarkView(Scanner scanner) {
        menuMessage = "Выбирите действие над Mark\n" +
                "1.Вывести по id\n" +
                "2.Создать\n" +
                "3.Обновить\n" +
                "4.Удалить\n" +
                "5.Выйти в главное меню";
        this.markController = new MarkController();
        this.scanner = scanner;
    }

    public void show() {
        while (true) {

            System.out.println(menuMessage);
            String s = scanner.next();

            if (s.equals("1")) {
                System.out.println("Введите id оценки = ");
                int id = scanner.nextInt();
                System.out.println(markController.getById(id));
            } else if (s.equals("2")) {
                System.out.println("Введите id студента = ");
                int student_id = scanner.nextInt();
                System.out.println("Введите id предмета =");
                int course_id = scanner.nextInt();
                System.out.println("Введите оценку = ");
                int mark = scanner.nextInt();
                System.out.println("Введите номер четверти = ");
                int quarter = scanner.nextInt();
                markController.create(course_id, student_id, mark, quarter);
            } else if (s.equals("3")) {
                System.out.println("Введите id оценки = ");
                int id = scanner.nextInt();
                System.out.println("Введите id предмета =");
                int course_id = scanner.nextInt();
                System.out.println("Введите id студента = ");
                int student_id = scanner.nextInt();
                System.out.println("Введите оценку = ");
                int mark = scanner.nextInt();
                markController.update(id, course_id, student_id, mark);
            } else if (s.equals("4")) {
                System.out.println("Введите id оценки = ");
                int id = scanner.nextInt();
                markController.delete(id);
            } else {
                break;
            }
        }
    }
}
