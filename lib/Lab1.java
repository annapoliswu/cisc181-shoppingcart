// Zihan Anna Wu - Section 080 - 2/14/18

package com.example.lib;

import java.io.*;
import java.lang.Math;
import java.util.Scanner;

// User inputs 1 to solve a basic physics problem, 2 to draw a particular pattern with print commands,
// and 3 to find the most common character in a string. Checks if user inputs are valid.
public class Lab1 {
    public static void main(String[] args) {

        System.out.println("Please input 1 to solve a physics problem, 2 to print a pyramid, or 3 to find the most common character in a string.");
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();

        if (input == 1) {
            System.out.println("Please input a theta in degrees and an initial velocity on one line.");
            if (scan.hasNextFloat()) {
                float theta = scan.nextFloat();

                if (scan.hasNextFloat()) {
                    float v = scan.nextFloat();
                    System.out.println(computeDistanceToLanding(theta, v));
                } else {
                    System.out.print("ERROR: Did not input 2 numbers.");
                }

            } else {
                System.out.print("ERROR: Did not input 2 numbers.");
            }

        } else if (input == 2) {
            System.out.println("Please input a integer for number of layers and two characters in that order.");
            if (scan.hasNextInt()) {
                int layers = scan.nextInt();

                if (scan.hasNext()) {
                    char char1 = scan.next().charAt(0);

                    if (scan.hasNext()) {
                        char char2 = scan.next().charAt(0);
                        drawLayeredPyramid(layers, char1, char2);
                    } else {
                        System.out.println("ERROR: did not input an int and 2 characters.");
                    }
                } else {
                    System.out.println("ERROR: did not input an int and 2 characters.");
                }
            } else {
                System.out.println("ERROR: did not input an int and 2 characters.");
            }

        } else if (input == 3){
            System.out.println("Please input a string.");
            Scanner scan2 = new Scanner(System.in);

            if(scan2.hasNext()) {
                String stringToCheck = scan2.nextLine();
                System.out.println(mostCommonChar(stringToCheck));
            } else {
                System.out.println("ERROR: Did not enter a string.");
            }

        } else
            System.out.println("ERROR: Did not input 1, 2, or 3.");
    }

    //Takes in an degree value and an initial velocity of a launched object and returns the horizontal distance travelled in meters.
    static float computeDistanceToLanding(float thetaDegrees,float initialVelocityMetersPerSecond){

        final float GRAVITY = 9.8f;
        float thetaRadians = (float) (thetaDegrees * Math.PI / 180);

        return  (float) ( 2 * Math.pow( initialVelocityMetersPerSecond , 2) * Math.sin(thetaRadians) * Math.cos(thetaRadians) / GRAVITY );
    }

    //Takes in a number of layers and two characters and prints a pyramid with those two characters alternating every layer.
    static void drawLayeredPyramid(int numLayers, char firstChar, char secondChar){

        for( int i = numLayers; i > 0 ; i-- ){
            int charNum = i;

            if (i % 2 == 0){
                while(charNum > 0){
                    System.out.print(firstChar);
                    charNum--;
                }
                System.out.println();
            }
            else{
                while(charNum > 0){
                    System.out.print(secondChar);
                    charNum--;
                }
                System.out.println();
            }
        }
    }

    //Takes in a string and returns the most common character in said string.
    static char mostCommonChar(String queryString){
        char mostCommon = queryString.charAt(0);  //-> rewrite indexes to match.
        int currentCount = 0;
        int compareCount = 0;

        for(int i = 0; i < queryString.length(); i++ ){
            for(int k = 0; k < queryString.length(); k++ ){
                if (queryString.charAt(i) == queryString.charAt(k)) {
                    currentCount++;
                }
            }
            if (currentCount > compareCount ){
                mostCommon = queryString.charAt(i);
                compareCount = currentCount;
            }
            else if (currentCount == compareCount && Character.valueOf(queryString.charAt(i)).compareTo(Character.valueOf(mostCommon)) < 0 ){
                mostCommon = queryString.charAt(i);
            }
            currentCount = 0;
        }
        return mostCommon;
    }

}

