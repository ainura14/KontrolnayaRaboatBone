package Bone.ThirdStage;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] predictedNumberComputer = new int[3];
        int[] computerSumBones = new int[3];
        int[] resultComputerBone = new int[3];
        int[] predictedNumberUser = new int[3];
        int[] userSumBones = new int[3];
        int[] resultUserBone = new int[3];
        int totalUserResult = 0, totalComputerResult = 0, totalRU = 0, totalRC = 0;

        for (int i = 0; i < 3; i++) {
            System.out.println("---        Start game           ---");
            System.out.println("Predict amount of points (2..12): ");
            predictedNumberUser[i] = scanner.nextInt();

            int userBone1 = rollTheDice();
            int userBone2 = rollTheDice();
            userSumBones[i] = userBone1 + userBone2;

            System.out.println("User rolls the dices...");

            printDice(userBone1);
            System.out.println();
            printDice(userBone2);

            resultUserBone[i] = userSumBones[i] - Math.abs(userSumBones[i] - predictedNumberUser[i]) * 2;
            System.out.println("On the dice fell " + userSumBones[i] + " points.");
            System.out.println("Result is " + userSumBones[i] + " - abs(" + userSumBones[i] + " - " + predictedNumberUser[i] + ") * 2: " + resultUserBone[i] + " points.");

            for (int j = i; j < 3; j++) {

                predictedNumberComputer[j] = random.nextInt(2, 13);

                int computerBone1 = rollTheDice();
                int computerBone2 = rollTheDice();

                computerSumBones[j] = computerBone1 + computerBone2;

                System.out.println();

                System.out.println("Computer predicted " + predictedNumberComputer[j] + " points.");
                System.out.println("Computer rolls the dices...");

                printDice(computerBone1);
                printDice((computerBone2));

                resultComputerBone[j] = computerSumBones[j] - Math.abs(computerSumBones[j] - predictedNumberComputer[j]) * 2;

                System.out.println("On the dice fell " + computerSumBones[j] + " points.");
                System.out.println("Result is " + computerSumBones[j] + " - abs( " + computerSumBones[j] + " - " + predictedNumberComputer[j] + ") * 2: " + resultComputerBone[j] + " points.");

                System.out.println("------------ " + "Current score" + "--------------");
                System.out.println("User: " + resultUserBone[i] + " points");
                System.out.println("Computer: " + resultComputerBone[j] + " points");
                if(resultUserBone[i] > resultComputerBone[j]){
                    int differenceUser =resultUserBone[i] - resultComputerBone[j];
                    System.out.println("User is ahead by " + differenceUser + " points!");
                }else if(resultComputerBone[j] > resultUserBone[i]){
                    int differenceComputer = resultComputerBone[j] - resultUserBone[i];
                    System.out.println("Computer is ahead by " + differenceComputer + " points!");
                } else if (resultUserBone == resultComputerBone) {
                    System.out.println("Draw in the game.");
                }
                totalUserResult += resultUserBone[i];
                totalComputerResult += resultComputerBone[j];
                break;
            }
            System.out.println("--------------------------------------------------");
        }
        System.out.printf("""
               ------------- Finish game --------------------
                   Round |      User    |    Computer 
                 --------+-----------+-------------
                         | Predicted: %d| Predicted: %d
                   - 1 - | Dice: %d     | Dice:%d
                         | Result: %d   | Result: %d
                """, predictedNumberUser[0], predictedNumberComputer[0], userSumBones[0], computerSumBones[0], resultUserBone[0], resultComputerBone[0]);
        System.out.printf(""" 
                   --------+-----------+-------------
                           | Predicted: %d| Predicted: %d
                    - 2 -  | Dice: %d     | Dice:%d
                           | Result: %d   | Result: %d
                        """, predictedNumberUser[1], predictedNumberComputer[1], userSumBones[1], computerSumBones[1], resultUserBone[1], resultComputerBone[1]);
        System.out.printf("""   
                  --------+-----------+-------------
                          | Predicted: %d| Predicted: %d
                   - 3 -  | Dice: %d     | Dice:%d
                          | Result: %d   | Result: %d
                       """, predictedNumberUser[2], predictedNumberComputer[2], userSumBones[2], computerSumBones[2], resultUserBone[2], resultComputerBone[2]);
        System.out.printf("""
                 --------+-----------+-------------
                 Total   | Points: %d    | Points: %d
                """, totalUserResult, totalComputerResult);

        if(totalUserResult > totalComputerResult){
            totalRU = totalUserResult - totalComputerResult;
            System.out.println("Users win " + totalRU   + " points more. Congratulations!" );
        }else if(totalUserResult < totalComputerResult){
            totalRC = totalComputerResult - totalUserResult;
            System.out.println("Computers win " + totalRC+ " points more. Congratulations!" );
        }else{
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
