package hexlet.code;

import java.util.Scanner;

public class Cli {

    public static void welcome(){
        Scanner scan = new  Scanner(System.in);
        System.out.println("May I have your name?");
        String name = scan.next();
        System.out.printf("Welcome, %s!",name);
    }

}
