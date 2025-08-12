import java.util.*;

public class RandomGen {
  public static void main(String[] args) {
    int randomNumber, maxValue;
    int[] array = {}
    Random rand = new Random();
    Scanner sn = new Scanner(System.in);
    do {
        System.out.println("Enter a whole number from 1-20: ");
        while (!sn.hasNextInt()) { // validate integer input
            System.out.println("That's not a whole number. Try again: ");
            sn.next(); // discard invalid input
        }
        maxValue = sn.nextInt();
    } while (maxValue < 1 || maxValue > 20); // validate range
                                             
    for (int i = 0, i < maxValue , i++){
      randomNumber = rand.nextInt(maxValue);

    }


    
  }
  
}
