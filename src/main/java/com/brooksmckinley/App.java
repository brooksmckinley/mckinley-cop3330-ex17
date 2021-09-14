/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution
 *  Copyright 2021 Brooks McKinley
 */

package com.brooksmckinley;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sex = promptNumber("Enter a 1 if you are male or 2 if you are female: ", scan);
        int ounces = promptNumber("How many ounces of alcohol did you have? ", scan);
        int weight = promptNumber("What is your weight, in pounds? ", scan);
        int hours = promptNumber("How many hours has it been since your last drink? ", scan);

        System.out.println(getAlcoholReport(sex, ounces, weight, hours));
    }

    public static int promptNumber(String prompt, Scanner scan) {
        while (true) {
            System.out.print(prompt);
            try {
                int res = Integer.parseInt(scan.nextLine());
                return res;
            } catch (Exception e) {
                // Handle user putting something that isn't a number
                System.out.println("Please enter a number.");
            }
        }
    }

    public static String getAlcoholReport(int sex, int ounces, int weight, int hours) {
        double BAC = getBAC(sex, ounces, weight, hours);

        return "Your BAC is " + String.format("%.6f", BAC) + "\n" +
                "It is " + (BAC > 0.08 ? "not " : "") + "legal for you to drive.";
    }

    public static double getBAC(int sex, int ounces, int weight, int hours) {
        double ratio = sex == 1 ? 0.73 : 0.66;
        return (ounces * 5.14 / weight * ratio) - (0.015 * hours);
    }
}