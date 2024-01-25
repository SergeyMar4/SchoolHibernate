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

    }
}
