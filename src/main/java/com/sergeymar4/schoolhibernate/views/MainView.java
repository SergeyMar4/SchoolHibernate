package com.sergeymar4.schoolhibernate.views;

import java.util.Scanner;

public class MainView {
    private String menuMessage;
    private CourseView courseView;
    private StudentView studentView;
    private TeacherView teacherView;
    private MarkView markView;
    private SchoolClassView schoolClassView;
    private Scanner scanner;

    public MainView() {
        this.menuMessage = "Выбирите клас для работы\n" +
                            "1.Student\n" +
                            "2.Course\n" +
                            "3.Teacher\n" +
                            "4.SchoolClass\n" +
                            "5.Mark\n" +
                            "6.Завершить программу";
        this.scanner = new Scanner(System.in);
        this.courseView = new CourseView(scanner);
        this.studentView = new StudentView(scanner);
        this.teacherView = new TeacherView(scanner);
        this.schoolClassView = new SchoolClassView(scanner);
        this.markView = new MarkView(scanner);
    }

    public void run() {
        while (true) {

            System.out.println(menuMessage);
            String s = scanner.next();

            if (s.equals("1")) {
                studentView.show();
            } else if (s.equals("2")) {
                courseView.show();
            } else if (s.equals("3")) {
                teacherView.show();
            } else if (s.equals("4")) {
                schoolClassView.show();
            } else if (s.equals("5")) {
                markView.show();
            } else {
                break;
            }
        }
    }
}
