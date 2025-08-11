import java.util.*;
public class BankManager {
  public static void main(String[] args) {
    boolean continueProgram = true; 
    int userInput;
    double countSaving, totalDeposit, userDeposit, countDeposit, targetSaving ;
    countSaving = 0;
    totalDeposit = 0;
    countDeposit = 0;
    targetSaving = 0;
    Scanner sc = new Scanner(System.in);

    while (continueProgram) {
      if (targetSaving <= totalDeposit && targetSaving != 0){
        System.out.println("Saving goal reached!");
      }

      System.out.println();
      System.out.println("What do you want to do?");
      System.out.println("Select from the following options:");
      System.out.println("\t1) Edit saving target");
      System.out.println("\t2) Deposit money");
      System.out.println("\t3) Display bank account info");
      System.out.println("\t0) Exit Program");
      System.out.print("Enter input: ");

      if (sc.hasNextInt()){
        userInput = sc.nextInt();
        switch (userInput) {
          case 1:
            System.out.print("Enter target saving($): ");
            targetSaving = sc.nextDouble();
            countSaving += 1;
            
            break;
          case 2:
            System.out.print("Enter deposite value($): ");
            userDeposit = sc.nextDouble();
            totalDeposit += userDeposit;
            countDeposit += 1;
            
            break;
          case 3:
            System.out.println();
            System.out.println("Total balance: " + totalDeposit);
            System.out.println("Number of deposit made: " + countDeposit);
            System.out.println("Average deposit size: " + totalDeposit/countDeposit);
            System.out.println("Amount left until Saving Target reached: " + (targetSaving - totalDeposit));
            System.out.println("Number of average of deposit til target reached: " + targetSaving/totalDeposit);
            
            break;
          case 0:
            System.out.println("Terminating program. Exit 0");
            continueProgram = false;
            break;
        
          default:
            System.out.println("Invalid integer input, try again");
            break;
        }
      }

      else {
        System.out.println("Invalid option, try again");
      }




    }
  }
  
}
