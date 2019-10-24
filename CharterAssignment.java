// Author: Hayden Migliore
// Date: October 23rd, 2019
// Assignment: A retailer offers a rewards program to its customers, awarding 
// points based on each recorded purchase. A customer receives 2 points for 
// every dollar spent over $100 in each transaction, plus 1 point for every 
// dollar spent over $50 in each transaction
// (e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).
// Given a record of every transaction during a three month period, calculate 
// the reward points earned for each customer per month and total.
// • Make up a data set to best demonstrate your solution
// • Check solution into GitHub

package charterAssignment;
import java.util.*;
import java.io.*;

public class CharterAssignment {
    
    public static void main(String[] args) {
        //Begin loop to check multiple files
        while(true){
            //Get file name or exit command from user
            Scanner consoleScanner = new Scanner(System.in);
            System.out.println("Please enter a file name or \"exit\" to exit. (test.txt or errorTest.txt)");
            String fileName = consoleScanner.next();
            
            //Check if the user wants to exit
            if (fileName.equalsIgnoreCase("exit")){
                //Clean up consoleScanner
                consoleScanner.close();
                System.exit(0);
            }
            
            //Try to find file name
            try{
                //Get file from 
                File file = new File(fileName);
                Scanner fileScanner = new Scanner(file);
                
                //Loop through each customer
                while(fileScanner.hasNext()){
                    //Get single customer and customer's purchases
                    String customer = fileScanner.nextLine();
                    String[] purchase1 = fileScanner.nextLine().split(" ");
                    String[] purchase2 = fileScanner.nextLine().split(" ");
                    String[] purchase3 = fileScanner.nextLine().split(" ");
                    int[] points1 = new int[purchase1.length];
                    int[] points2 = new int[purchase2.length];
                    int[] points3 = new int[purchase3.length];
                    int totalPoints1 = 0;
                    int totalPoints2 = 0;
                    int totalPoints3 = 0;
                    
                    //Calculate points for each month
                    for (int i = 0; i < purchase1.length; i++){
                        points1[i] = calculatePoints(Integer.parseInt(purchase1[i]));
                        totalPoints1 += points1[i];
                    }
                    for (int i = 0; i < purchase2.length; i++){
                        points2[i] = calculatePoints(Integer.parseInt(purchase2[i]));
                        totalPoints2 += points2[i];
                    }
                    for (int i = 0; i < purchase3.length; i++){
                        points3[i] = calculatePoints(Integer.parseInt(purchase3[i]));
                        totalPoints3 += points3[i];
                    }
                    
                    //Print results
                    System.out.println("\nCustomer: " + customer + "\n");
                    System.out.println("Purchases for month 1: " + Arrays.toString(purchase1));
                    System.out.println("Points for month 1: " + Arrays.toString(points1));
                    System.out.println("Total points for month 1: " + totalPoints1 + "\n");
                    System.out.println("Purchases for month 2: " + Arrays.toString(purchase2));
                    System.out.println("Points for month 2: " + Arrays.toString(points2));
                    System.out.println("Total points for month 2: " + totalPoints2 + "\n");
                    System.out.println("Purchases for month 3: " + Arrays.toString(purchase3));
                    System.out.println("Points for month 3: " + Arrays.toString(points3));
                    System.out.println("Total points for month 3: " + totalPoints3 + "\n");
                    System.out.println("Total points for " + customer + ": " + (totalPoints1 + totalPoints2 + totalPoints3) + "\n"); 
                }
                
                //Clean up fileScanner
                fileScanner.close();
            }
            catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    
    //Calculate points for a single purchase
    static int calculatePoints(int purchase){
        int points = 0;
        if (purchase > 100){
            points = 2 * (purchase - 100) + 50; //2 points for every dollar over $100 plus 50 points
        }
        else if (purchase > 50){
            points = purchase - 50;// 1 point for every dollar over $50
        }
        return points;
    }
    
}
