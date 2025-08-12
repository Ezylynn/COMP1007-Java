/*
 * Author: Binh
 * Purpose: To perform Mathetical operations: Addition, Multiplication and Divisibility test
 * Date: 2025-08-05
 */
// TODO Fix the switch condition loop

import java.util.*;
public class MathOps {
  public static void main(String[] args) {
    int num1, num2, numsResult, userInput;
    boolean continueLoop = true;
    boolean inputValid = false;
    Scanner sc = new Scanner(System.in); // import new scanner object to
    System.out.println("Welcome to PDI Week 3!!!");

    while (continueLoop){
      inputValid = false;

      System.out.println();
      System.out.println("What would you like to do?");
      System.out.println("\t>1. Sum of 2 integers");
      System.out.println("\t>2. Product of 2 integers");
      System.out.println("\t>3. Determine if 2 Integers are Divisible");
      System.out.println("\t>0. Exit");
      System.out.print("Enter input: ");

      // check if value input is int 
      if(sc.hasNextInt()){
        userInput = sc.nextInt(); // take user input in the form of int as options

        // listing cases depending on user selected options
        switch(userInput){
          case 1:
            // output the sum of 2 numbers
            do{
              System.out.print("Enter Num 1: ");
              if (sc.hasNextInt()){
                num1 = sc.nextInt();
                System.out.print("Enter Num 2: ");
                if (sc.hasNextInt()){
                  num2 = sc.nextInt();
                  numsResult = num1 + num2;
                  System.out.println("Result: "+ numsResult);
                  System.out.println("Exit program...");
                  inputValid = true;
                  continueLoop = false;
                  break;
                }
                else{
                  System.out.println("Try again. Has to be an integer");
                  sc.next();
                }
              }
              else{
                System.out.println("Try again. Has to be an integer");
                sc.next();
              }
        
            }
            while(!inputValid);


          case 2:
            // output product of 2 numbers
            do{
              System.out.print("Enter Num 1: ");
              if (sc.hasNextInt()){
                num1 = sc.nextInt();
                System.out.print("Enter Num 2: ");
                if (sc.hasNextInt()){
                  num2 = sc.nextInt();
                  numsResult = num1 * num2;
                  System.out.println("Result: "+ numsResult);
                  System.out.println("Exit program...");
                  inputValid = true;
                  continueLoop = false;
                  break;
                }
                else{
                  System.out.println("Try again. Has to be an integer");
                  sc.next();
                }
              }
              else{
                System.out.println("Try again. Has to be an integer");
                sc.next();
              }
        
            }
            while(!inputValid);
            break;
          case 3:
            // apply modulo to test divisility between 2 numbers
            do{
              System.out.print("Enter Num 1: ");
              if (sc.hasNextInt()){
                num1 = sc.nextInt();
                System.out.print("Enter Num 2: ");
                if (sc.hasNextInt()){
                  num2 = sc.nextInt();
                  if (num1%num2==0 || num2%num1==0){
                    System.out.println(num1 +" & " + num2 + " are divisible");
                  }
                  else{
                    System.out.println(num1 +" & " + num2 + " are NOT divisible");
                  }
                  System.out.println("Exit program...");
                  inputValid = true;
                  continueLoop = false;
                  break;
                }
                else{
                  System.out.println("Try again. Has to be an integer");
                  sc.next();
                }
              }
              else{
                System.out.println("Try again. Has to be an integer");
                sc.next();
              }
            }
            while(!inputValid);
            break;
          case 0:
            // exit program, does nothing if 0
            System.out.println("Exit program...");
            continueLoop = false;
            break;
          default:
            // default output if user enter integer beyond 0-3 
            System.out.println("Integer entered but invalid option, try again");
            
        }
      }
      else{
        // stop program if input isn't an integer
        System.out.println("Invalid output, try again"); 
        sc.next();
      }

    }

    sc.close(); // stop receiving any inputs
  }
}
