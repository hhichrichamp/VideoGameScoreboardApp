/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videogamescoreboardapp;

import java.util.Scanner;

/**
 *
 * @author hhichri
 */
public class Utilities {

    public static int getUserChoice(String prompt) {
        int choice = 0;
        System.out.println(prompt);
        Scanner myScanner = new Scanner(System.in);
        choice = myScanner.nextInt();
        return choice;
    }

    public static int findHighest(int[] numbers) {
        int highest = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > highest) {
                highest = numbers[i];
            }
        }
        return highest;
    }

    public static int findLowest(int[] numbers) {
        int lowest = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < lowest) {
                lowest = numbers[i];
            }
        }
        return lowest;
    }

    public static int findTotal(int[] units) {
        int total = 0; // Initialize accumulator
        for (int i = 0; i < units.length; i++) {
            total += units[i];
        }
        return total;
    }

    public static int findAveage(int[] units) {
        int total = Utilities.findTotal(units); // Initialize accumulator

        return total / units.length;
    }

    public static void selectionSort(double[] list) {
        for (int i = 0; i < list.length; i++) {
            // Find the minimum in the list[i..list.length-1]
            double currentMin = list[i];
            int currentMinIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (currentMin > list[j]) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }

            // Swap list[i] with list[currentMinIndex] if necessary;
            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }

}
