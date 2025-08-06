/* 
 Author: Binh
 Purpose: To convert ASCII character to upper/lowercase & vice versa
 Date: 2025-08-05
 */

import java.util.*;
public class ASCII_Converter{
  public static void main(String[] args) {
    char lowChar, upChar, lowCharInput, upCharInput, userInput; // declaring variable for upper and lowercase character
    int  lowCharNum , upCharNum; // declaring variable for upper/lowercase character decimal number
    Scanner sn = new Scanner(System.in); // create new Scanner object to take input
    System.out.println("What do you want to convert your character into?");
    System.out.println("\t (U)ppercase");
    System.out.println("\t (L)owercase");
    System.out.print("Enter input: ");
    userInput = sn.next().charAt(0); // only take input of character

    // condition if char is U or u
    if (userInput == 'U' || userInput == 'u'){ 
      System.out.print("Enter an uppercase char: ");
      upCharInput = sn.next().charAt(0); // take uppercase char as an input
      upChar = Character.toUpperCase(upCharInput); // convert char into uppercase 
      lowCharNum = (int)upChar + 32; // typecasting char into int to get the ASCII decimal number of lowercase char
      lowChar = (char)lowCharNum; // typecasting int into ASCII char
      System.out.println("The lowercase character is "+lowChar);
    }
      // condition is char is L or l
      else if (userInput == 'L' || userInput == 'l'){
        System.out.print("Enter an lowercase char: ");
        lowCharInput = sn.next().charAt(0); // take lowercase char as an input
        lowChar = Character.toLowerCase(lowCharInput); // convert char into lowercase
        upCharNum = (int)lowChar - 32; // typecasting char into int to get ASCII decimal number of uppercase char
        upChar = (char)upCharNum; // typecasting into into ASCII char
        System.out.println("The uppercase character is "+upChar);
    }                               
      else{
        System.out.println("Invalid input. Terminating program...please try again");

      }


  }

}
