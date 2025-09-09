public class TestParser{
  public static void main(String[] args){
    String text = "apple,banana,grapes,oranges";
    String[] tokens = text.split(",");
    System.out.println(tokens);
    for (String token : tokens){
      System.out.print(token + " ");
    }

    int[] testArr = {1,2,3,4,5,6,7,8,9,0};
    int[] newArr = copyIntArray(testArr);


    printArray(testArr);
    printArray(newArr); 

    
  }

  public static int[] copyIntArray(int[] arrayToCopy){
    int[] dupArray;
    dupArray = new int[arrayToCopy.length];

    for (int i =0; i < arrayToCopy.length; i++){
      dupArray[i] = arrayToCopy[i]; 
    }
    return dupArray; 
  }

  public static void printArray(int[] arrayToPrint){
    System.out.println();
    System.out.print("[");
    for (int i = 0; i < arrayToPrint.length; i++){
      if (i == arrayToPrint.length - 1){
        System.out.print(arrayToPrint[i]);
      }
      else{
        System.out.print(arrayToPrint[i] + ",");
      }
    }
    System.out.print("]");
  }

}
