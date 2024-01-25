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

    }
}
