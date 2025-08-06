import java.util. *;

public class Calculator
{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int numOne, numTwo, answer;

    System.out.print("Enter first num");
    numOne = sc.nextInt();

    System.out.print("Enter first num");
    numTwo = sc.nextInt();

    answer = numOne + numTwo;

    System.out.println("The answer is:" + numOne + "+" + numTwo+ "=" + answer);
    sc.close();
  }
}
