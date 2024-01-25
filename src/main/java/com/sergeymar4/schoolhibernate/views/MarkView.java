package com.sergeymar4.schoolhibernate.views;

import com.sergeymar4.schoolhibernate.controllers.CourseController;
import com.sergeymar4.schoolhibernate.controllers.MarkController;

import java.util.Scanner;

public class MarkView {
    private String menuMessage;
    private MarkController markController;
    private Scanner scanner;

    public MarkView(Scanner scanner) {
        menuMessage = "Выбирите действие над Course\n" +
                "1.Вывести по id\n" +
                "2.Создать\n" +
                "3.Обновить\n" +
                "4.Удалить\n" +
                "5.Выйти в главное меню";
        this.markController = new MarkController();
        this.scanner = scanner;
    }

    public void show() {

    }
}
