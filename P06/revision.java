import java.util.*;
public class revision{

  public static void main(String [] args){
    System.out.println(addNumber(1,2));


    revision mathObj = new revision();
    System.out.println(mathObj.productNumber(2,2));

    System.out.println(addNumber(99,1));

    String[] array = new String[3];
    String[] array1 = {"meow", "mew", "woof"};

    for (String i: array1){
      System.out.println(i);
    }

    System.out.println();

    for (int i = 0; i < array1.length; i++){
      System.out.println(array1[i]);
    }

    double num = 100;
    do {
      num = num/2;
      System.out.println(num);
    }
    while (num > 1);

    Scanner sn = new Scanner(System.in);
    System.out.println("Enter input of a char");
    char meow = sn.next().charAt(0);

    System.out.println(meow);

  }

  static int addNumber(int num1, int num2){
    return num1 + num2;
  }

  int productNumber(int num1, int num2){
    return num1 * num2;
  }
}
