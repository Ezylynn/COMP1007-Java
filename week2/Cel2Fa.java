import java.util.*;
public class Cel2Fa {
  public static void main(String[] args) {
    double Cel, Fa;
    Scanner sn = new Scanner(System.in);
    System.out.print("Enter a degree in Celsius");
    Cel = sn.nextDouble();
    Fa = (Cel * 9/5) + 32;

    System.out.println(Cel + " Celsius is " + Fa + " in Farenheiht!");
  }
}
