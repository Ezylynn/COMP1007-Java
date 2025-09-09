/*
 * Author: Binh
 * Purpose: A functional CSV parser to manage students assessments data
 * Date: 2025-09-10
 */
import java.util.Scanner; // import java lib for Scanner
import java.io.*;// import java lib to access File handling classes

public class csvParser{
  public static void main(String[] args){
    // initializing parallel arrays, define length to pass through methods
    String[] names = new String[20];
    int[] studentID = new int[20];
    double[] marks = new double[20];
    Scanner sn = new Scanner(System.in);

    System.out.print("Enter only the file name, excluding the file extension: ");
    String fileInput = sn.nextLine();
    readFile(fileInput, names, studentID, marks);
  }


  public static void readFile(String fileInput, String[] names, int[] studentID, double[] marks){
    try{


      FileInputStream file = new FileInputStream(fileInput + ".txt"); // create obj for the input stream
      InputStreamReader isr = new InputStreamReader(file); // create obj to read the data stream
      BufferedReader br = new BufferedReader(isr); // more efficient reader than isr
      String line;
      int lineNum = 0;

      line = br.readLine(); // read one line at time
      while (line != null){ // when at EOF --> br return null
        if (lineNum == 20){ 
          System.out.println("Total number of lines exceed 20. Stopping processing of file");
          break;
        } 
        else{
          processFile(line,names,studentID,marks, lineNum); // to check validity of data
          lineNum+=1;
          line = br.readLine(); // read onto the next line
        }
      } 
      printFile(names,studentID,marks, lineNum); // iterate over parallel arrays to print data rows
    }
    catch(IOException e){
      System.out.println("Error handling file: " + e);
    }
  } 
  public static void processFile(String line,String[] names, int[] studentID, double[] marks, int index){
    try{
      String[] tempArr = line.split(","); // parsing csv --> array
      String name = tempArr[0];
      int id = Integer.parseInt(tempArr[1]); // convert string "interger" into actual int num
      double mark = Double.parseDouble(tempArr[2]); // convert string "double" into actual int double 

      // data row is skipped if username is empty, id not between 1000000 & 9999999, mark is not between 0 & 100
      if (!name.trim().isEmpty() && (id >= 10000000 && id <= 99999999) && (mark >= 0 && mark <= 100)){
        names[index] = name;
        marks[index] = mark;
        studentID[index] = id;
      }
      else{
        System.out.println("Invalid data format. Skiping to next row");
        return;
      }
    }
    catch(Exception e)
    {
      System.out.println("Unexpected error occur:" + e);
    }
  }

  public static void printFile(String[] names, int[] studentID, double[] marks, int max){
    System.out.println("No   Name   Student ID   Marks");
    for (int i = 0; i < max; i++){
      System.out.println(i + "   " + names[i] + "   " + studentID[i] + "   " + marks[i]);
    }
  }

}
