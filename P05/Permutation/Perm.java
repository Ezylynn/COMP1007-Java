/*
 * Author: Binh 
 * Purpose: To work out permutation based on user inputs
 * Date: 2025-08-19
*/
import java.util.*;

public class Perm{
  public static void main(String[] args) {
    int n, rMax;
    Scanner sn = new Scanner(System.in);
    // loop condition to ensure input is between 5 and 50 (inclusive)
    do{
      System.out.print("Enter number of elements: ");
      n = sn.nextInt();
    }
    while (n < 5 || n > 50);

    // loop condition to ensure input is between 2 (inclusive) and n (exclusive)
    do{
      System.out.print("Enter max number of elements ");
      rMax = sn.nextInt();
    }
    while (rMax < 2 || rMax >= n);

    // initailizing new array and lenth 
    int[] myArray = new int[rMax-1];

    // assigning each permutation value to an array index 
    for (int r = 0; r < rMax-1; r++) {
      myArray[r] = factorial(n)/factorial((n-(r+2)));
    }

    // outputting each value in the array 
    for (int counter =0; counter < myArray.length; counter++){
      System.out.println(myArray[counter]);
    }

    
    
  }

  //METHOD: factorial
  //IMPORT: integer n
  //EXPORT: integer product
  //ASSERTION: To workout the factorial of any integer number
  static int factorial(int n){
    int product = 1;
    for (int i =1; i <=n; i++){
      product = product * i;
    }
    return product;
  }
}

