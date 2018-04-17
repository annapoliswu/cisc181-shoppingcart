// Zihan Anna Wu - Section 080 - 2/7/18

package com.example.lib;

import java.io.*;
import java.util.Scanner;
import java.lang.Math;

//calls convertSeconds if user inputs 1, heronsFormula if user inputs 2, or prints error message
public class Lab0 {
    public static void main(String[] args) {

        System.out.println("Enter 1 to use Heron's formula or enter 2 to convert to seconds:");
        Scanner scan = new Scanner(System.in);

        int input;
        if (scan.hasNextInt() ) {
            input = scan.nextInt();
            if (input == 1) {
                heronsFormula();
            } else if (input == 2) {
                convertSeconds();
            } else {
                System.out.println("ERROR: entered an int outside of 1 or 2");
            }
        }
        else {
            System.out.println("ERROR: did not enter an int value");
        }
    }


    //Takes in a integer representing the number of seconds and prints the number of days, hours, minutes, and seconds accordingly.
    static void convertSeconds(){
        System.out.println("Please enter a positive integer value representing the number of seconds");
        Scanner scan = new Scanner(System.in);

        if (scan.hasNextInt()){
            int s = scan.nextInt();
            int d = s / 86400;
            int h = (s - d * 86400) / 3600;
            int m = (s - d * 86400 - h * 3600) / 60;
            s = s - d * 86400 - h * 3600 - m * 60;

            if (d == 1) {
                System.out.println(d + " day");
            } else if (d > 0) {
                System.out.println(d + " days");
            }

            if (h == 1) {
                System.out.println(h + " hour");
            } else if (h > 0 && d <= 0 || d > 0) {
                System.out.println(h + " hours");
            }

            if (m == 1) {
                System.out.println(m + " minute");
            } else if (m > 0 && h <= 0 && d <= 0 || h > 0 || d > 0) {
                System.out.println(m + " minutes");
            }

            if (s == 1) {
                System.out.println(s + " second");
            } else {
                System.out.println(s + " seconds");
            }
        } else {
            System.out.println("ERROR: did not enter an integer type.");
        }
    }

    // Takes in 3 Double values as side lengths. Prints the semi-perimeter, area, and angle (in that order) if a triangle is form-able. Prints ERROR if not form-able.
    static void heronsFormula() {
        System.out.println("Please enter 3 Double values");
        Scanner scan = new Scanner(System.in);

        Double a;
        Double b;
        Double c;

        if (scan.hasNextDouble()) {
            a = scan.nextDouble();

            if (scan.hasNextDouble()) {
                b = scan.nextDouble();

                if (scan.hasNextDouble()) {
                    c = scan.nextDouble();

                    if (a + b <= c || c + b <= a || a + c <= b || a < 0 || b < 0 || c < 0) {
                        System.out.println("ERROR: Cannot form triangle");
                    } else {
                        Double s = (a + b + c) / 2;
                        Double A = Math.sqrt(s * (s - a) * (s - b) * (s - c));
                        Double y = Math.acos((a * a + b * b - c * c) / (2 * a * b)) * 180 / Math.PI;

                        // Eg. System.out.format("%.3f%n", pi);

                        System.out.format("%.2f%n", s);
                        System.out.format("%.2f%n", A);
                        System.out.format("%.2f%n", y);
                    }

                } else
                    System.out.println("Did not enter 3 double values.");
            } else
                System.out.println("Did not enter 3 double values.");
        } else
            System.out.println("Did not enter 3 double values.");



    }
}

