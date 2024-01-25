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

    }
}
