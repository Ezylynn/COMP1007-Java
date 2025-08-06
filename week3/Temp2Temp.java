/* 
Author: Binh
Purpose: Convert farenheiht/celcius to celsius/farenheiht
Date: 2025-08-05
*/
import java.util.*;
public class Temp2Temp{
  public static void main(String[] args) {
    // declaring variables for celsius and farenheiht
    double cel, fa;
    // declaring & initialize scanner object
    Scanner sn = new Scanner(System.in);

    System.out.println("Which temp scale are you converting from?");
    System.out.println("(C)elsius");
    System.out.println("(F)arenheit");
    // receive user input in the form of character
    char userInput = sn.next().charAt(0);

    // if condition for Celsius & account for lower/uppercase
    if (userInput == 'C' || userInput == 'c'){
      double tempInput = sn.nextDouble(); //input temperature
      fa = (tempInput*9/5)+32; //convert into farenheiht
      System.out.println(fa);
    }

    // if condition for Farenheiht & account for lower/uppercase
    else if (userInput == 'F' || userInput == 'f'){
      double tempInput = sn.nextDouble(); // input temperature
      cel = (tempInput -32) * 5/9; // convert into farenheiht
      System.out.println(cel);
    }
      else{
        System.out.println("invalid input");
      }
  }
}
