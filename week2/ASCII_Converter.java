import java.util.*;
public class ASCII_Converter{
  public static void main(String[] args) {
    char LowerChar, UpperChar;
    int  LowerCharNum , UpperCharNum;
    Scanner sn = new Scanner(System.in);

    System.out.print("Enter an uppercase char: ");
    UpperChar = sn.next().charAt(0);
    UpperCharNum = (int) UpperChar;
    LowerCharNum = UpperCharNum + 32;
    LowerChar = (char) LowerCharNum;

    System.out.println("ASCII decimal value of " + UpperChar + " is " + UpperCharNum);
    System.out.print("ASCII lowercase value of " + UpperChar + " is " + LowerChar);
  }

}
