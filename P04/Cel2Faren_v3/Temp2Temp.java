/* 
Author: Binh
Purpose: Convert farenheiht/celcius to celsius/farenheiht
Date: 2025-08-05
*/
import java.util.*;
public class Temp2Temp{
  public static void main(String[] args) {
    
    double cel, fa; // declaring variables for celsius and farenheiht
    char userInput = ' ';
    boolean userInputInvalid = true; // init variable for while loop

    // declaring & initialize scanner object
    Scanner sn = new Scanner(System.in);
    // while loop run if input doesn't fit the characters
    while (userInputInvalid){
      System.out.println();
      System.out.println("Which temp scale are you converting from?");
      System.out.println("(C)elsius");
      System.out.println("(F)arenheit");
      // receive user input in the form of character
      userInput = sn.next().charAt(0);
      if (userInput == 'C' || userInput == 'c' || userInput == 'F' || userInput == 'f'){
        userInputInvalid = false;
      }
      else{
        System.out.println("Invalid input, try again");
      }
    }
    // if condition for Celsius & account for lower/uppercase
    if (userInput == 'C' || userInput == 'c'){
      System.out.print("Input temp: ");
      double tempInput = sn.nextDouble(); //input temperature
      fa = (tempInput*9/5)+32; //convert into farenheiht
      System.out.println(fa);
    }

    // if condition for Farenheiht & account for lower/uppercase
    else if (userInput == 'F' || userInput == 'f'){
      System.out.print("Input temp: ");
      double tempInput = sn.nextDouble(); // input temperature
      cel = (tempInput -32) * 5/9; // convert into farenheiht
      System.out.println(cel);
    }
      else{
        System.out.println("invalid input");
      }
  }
}
