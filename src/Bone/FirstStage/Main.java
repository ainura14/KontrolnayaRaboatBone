package Bone.FirstStage;

import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
     static Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---        Start game           ---");
        System.out.println("Predict amount of points (2..12): ");
        int predictedNumber = scanner.nextInt();

        int first = rollTheDice();
        int second = rollTheDice();
        int sum = first + second;

        System.out.println("User rolls the dices...");

        printDice(first);
        System.out.println("*****************");
        printDice(second);

        System.out.println("On the dice fell " + sum + " points.");
        int result = sum - Math.abs(sum - predictedNumber) * 2;
        System.out.println("Result is " + sum + " - abs(" + sum + " - " + predictedNumber + ") * 2: " + result);

        if (result > 0){
            System.out.println("User wins!");
        }else {
            System.out.println("User can't predicted the bone.");
        }
    }

    public static int rollTheDice(){
        return random.nextInt(1, 7);
    }

    public static void printDice(int number){
        switch (number){
            case 1: {
                System.out.println("""
                        +---------+
                        |         |
                        |    #    |
                        |         |
                        +---------+
                        """);
                break;
            }
            case 2:{
                System.out.println("""
                        +---------+
                        | #       |
                        |         |
                        |        #|
                        +---------+
                        """);
                break;
            }
            case 3:{
                System.out.println("""
                        +---------+
                        | #       |
                        |    #    |
                        |        #|
                        +---------+
                        """);
                break;
            }
            case 4:{
                System.out.println("""
                        +---------+
                        | #     # |
                        |         |
                        | #     # |
                        +---------+
                        """);
                break;
            }
            case 5: {
                System.out.println("""
                        +---------+
                        | #     # |
                        |    #    |
                        | #     # |
                        +---------+
                        """);
                break;
            }
            case 6: {
                System.out.println("""
                        +---------+
                        | #  #  # |
                        |         |
                        | #  #  # |
                        +---------+
                        """);
                break;
            }
        }
    }
}
