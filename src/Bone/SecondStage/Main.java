package Bone.SecondStage;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---        Start game           ---");
        System.out.println("Predict amount of points (2..12): ");
        int predictedNumberUser = scanner.nextInt();

        int userBone1 = rollTheDice();
        int userBone2 = rollTheDice();
        int userSumBones = userBone1 + userBone2;

        System.out.println("User rolls the dices...");

        printDice(userBone1);
        System.out.println("*****************");
        printDice(userBone2);

        System.out.println("On the dice fell " + userSumBones + " points.");

        int resultUserBone = userSumBones - Math.abs(userSumBones - predictedNumberUser) * 2;
        System.out.println("Result is " + userSumBones + " - abs(" + userSumBones + " - " + predictedNumberUser + ") * 2: " + resultUserBone + " points.");

//        if (resultUserBone > 0){
//            System.out.println("User wins!");
//        }else {
//            System.out.println("User can't predicted the bone.");
//        }

        int predictedNumberComputer = random.nextInt(2, 13);

        int computerBone1 = rollTheDice();
        int computerBone2 = rollTheDice();

        int computerSumBones = computerBone1 + computerBone2;

        System.out.println();

        System.out.println("Computer predicted " + predictedNumberComputer + " points.");
        System.out.println("Computer rolls the dices...");

        printDice(computerBone1);
        printDice((computerBone2));

        int resultComputerBone = computerSumBones - Math.abs(computerSumBones - predictedNumberComputer) * 2;

        System.out.println("On the dice fell " + computerSumBones + "points.");
        System.out.println("Result is " + computerSumBones + " - abs( " + computerSumBones + " - " + predictedNumberComputer + ") * 2: " + resultComputerBone + " points.");


        if(resultUserBone > resultComputerBone){
            int differenceUser =resultUserBone - resultComputerBone;
            System.out.println("User win " + differenceUser + " points more." + "\n" + "Congratulations!");
        }else if(resultComputerBone > resultUserBone){
            int differenceComputer = resultComputerBone - resultUserBone;
            System.out.println("Computer win " + differenceComputer + " points more." + "\n" + "Congratulations!");
        } else if (resultUserBone == resultComputerBone) {
            System.out.println("Draw in the game.");
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

