package View;


import java.util.Scanner;

public class systemView {
    static Scanner scanner = new Scanner(System.in);
    public static void systemView() {
        System.out.println("********************************");
        System.out.println("欢迎使用学生管理系统,请选择您的操作");
        System.out.println("1.添加学生信息");
        System.out.println("2.显示当前所有学生");
        System.out.println("3.查询指定学生信息");
        System.out.println("4.修改指定学生信息");
        System.out.println("5.删除指定学生信息");
        System.out.println("0.退出系统");
    }
    public static void viewOut(String str){
        System.out.println(str);
    }
    public static String viewIn(){
        String str = scanner.next();
        return str;
    }
}
