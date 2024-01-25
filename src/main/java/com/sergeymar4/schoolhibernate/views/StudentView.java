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

    }
}
