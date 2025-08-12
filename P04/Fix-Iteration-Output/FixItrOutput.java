/*
 * Author: Binh
 * Purpose: To output a fixed number of iteration based on input
 * Date: 2025-08-12
 */

import java.util.*;

public class FixItrOutput {
  public static void main(String[] args) {
    Scanner sn = new Scanner(System.in); // create new Scanner object to take input

    System.out.print("Enter number of iterations to be output: ");
    int max = sn.nextInt();
    // set initial iteration to 1, increment by 1 from 1 to n+1
    for (int i = 1; i < max + 1; i++) {
      System.out.print(" "+i+" ");
    }
    sn.close();
  }
  
}
