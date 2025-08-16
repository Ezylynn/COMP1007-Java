/*
 * Author: Binh
 * Purpose: Generate 2D array based on row & column numbers inputted from user
 * Date: 2025-08-16
 */
import java.util.*;
public class ArrayGen {
  public static void main(String[] args) {
    // define and delcare variable
    int rowInput = 0, colInput = 0;
    Scanner sc = new Scanner(System.in);


    // continue to loop until user enter positive integer value for row
      while (rowInput <= 0) {
        try {
          System.out.print("Enter number of rows: ");
          rowInput = sc.nextInt();
        } catch (InputMismatchException e) {
          sc.next(); // clear input field for the next input
          System.out.println("Invalid input. Please enter a positive integer value");
          System.out.println();
        }
      }

    // continue to loop until user enter positive integer value for col
      while (colInput <= 0) {
        try {
          System.out.print("Enter number of cols: ");
          colInput = sc.nextInt();
        } catch (InputMismatchException e) {
          sc.next(); // clear input field for the next input
          System.out.println("Invalid input. Please enter a positive integer value");
          System.out.println();
        }
      }

    // declare 2D array & define the row/column lengths
    int[][] user2DArray = new int[rowInput][colInput];

    // nested for loop to append value to array
    for (int row = 0; row < rowInput; row++){
      for (int col = 0; col < colInput; col++) {
        user2DArray[row][col] = row * col;
      }
    }

    // nested for loop to output value onto terminal in rows
    // manually output each value, as java will only print out memory address (object reference) to the array row/col, not content
    for (int row = 0; row < rowInput; row++){
      for (int col = 0; col < colInput; col++) {
        System.out.print(user2DArray[row][col] + " ");
      }
      System.out.println();
    }
    sc.close();
  }
}

