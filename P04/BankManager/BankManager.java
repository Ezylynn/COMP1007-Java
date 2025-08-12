/*
 * Author: Binh
 * Purpose: A stimulated terminal bank account in Java, user can set saving target, deposit and withdraw money
 * Date: 2025-08-12
 */
import java.util.*;
public class BankManager {
  public static void main(String[] args) {
    boolean continueProgram = true; // variable for kickstarting while loop
    int userInput;
    double countSaving = 0, totalDeposit = 0, userDeposit = 0, countDeposit = 0, targetSaving = 0; // variables for tracking savings and deposit 
    Scanner sc = new Scanner(System.in);

    while (continueProgram) {
      // Check if deposit meets target and is not zero
      if (targetSaving <= totalDeposit && targetSaving != 0){
        System.out.println("Saving goal reached!");
      }

      //terminal menu options for user
      System.out.println();
      System.out.println("What do you want to do?");
      System.out.println("Select from the following options:");
      System.out.println("\t1) Edit saving target");
      System.out.println("\t2) Deposit money");
      System.out.println("\t3) Display bank account info");
      System.out.println("\t0) Exit Program");
      System.out.print("Enter input: ");

      // Check if user input is an integer
      if (sc.hasNextInt()){
        userInput = sc.nextInt();

        switch (userInput) {
          // user set target saving
          case 1:
            System.out.print("Enter target saving($): ");
            targetSaving = sc.nextDouble();
            countSaving += 1;
            
            break;
          // user input deposite amount
          case 2:
            System.out.print("Enter deposite value($): ");
            userDeposit = sc.nextDouble();
            totalDeposit += userDeposit;
            countDeposit += 1;
            
            break;
          // display bank account details to user
          case 3:
            System.out.println();
            System.out.println("Total balance: " + totalDeposit);
            System.out.println("Number of deposit made: " + countDeposit);
            System.out.println("Average deposit size: " + totalDeposit/countDeposit);
            System.out.println("Amount left until Saving Target reached: " + (targetSaving - totalDeposit));
            System.out.println("Number of average of deposit til target reached: " + targetSaving/totalDeposit);
            
            break;
          // force exit out of program
          case 0:
            System.out.println("Terminating program. Exit 0");
            continueProgram = false;
            break;
        
          // default output if integer input is out of bound
          default:
            System.out.println("Invalid integer input, try again");
            break;
        }
      }

      // output response if input isn't integer
      else {
        System.out.println("Invalid option, try again");
      }
    }
  }
  
}
