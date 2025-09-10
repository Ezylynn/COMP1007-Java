/*
 * Author: Binh
 * Purpose: A functional CSV parser to manage students assessments data
 * Date: 2025-09-10
 */
import java.util.*; // import java lib for Scanner
import java.io.*;// import java lib to access File handling classes

public class csvParser{
  public static int lineNum = 0;
  public static String fileInput;
  public static void main(String[] args){
    // initializing parallel arrays for csv data format & define length to pass through methods
    String[] names = new String[20];
    int[] studentID = new int[20];
    double[] marks = new double[20];
    Scanner sn = new Scanner(System.in);
    int userInput;

    boolean continueLoop = true;
    while (continueLoop){
      try{
        // menu
        System.out.println();
        System.out.println("1> Import student data from CSV");
        System.out.println("2> Calculate test mark average");
        System.out.println("3> View all student data");
        System.out.println("4> Add a new student");
        System.out.println("0> Exit");
        System.out.print("Enter input: ");
        userInput = sn.nextInt();

        switch(userInput){
          case 1:
            lineNum = 0; // reset line num when import new file
            System.out.print("Enter file name: ");
            fileInput = sn.next();
            readFile(fileInput, names, studentID, marks); //import file into program 
            break;
          case 2:
            double avg = avgMark(names,marks,lineNum); // calculate avg mark, exlcuding invalid row
            System.out.println("Avergage score: " + avg);
            break;
          case 3:
            printFile(names,studentID,marks, lineNum); // iterate over parallel arrays to print data rows
            break;
          case 4:
            writeFile(names, studentID, marks,fileInput,lineNum); // append new data row to file
            break;
          case 0:
            continueLoop = false; //exit program
            break;
          default:
            // default output if user enter integer beyond 0-3 
            System.out.println("Integer entered but invalid option, try again");
            break;
        }
      }

      catch (InputMismatchException e){ // catch error if input isn't integer
              System.out.println("Error encountered: " + e);
              sn.next();
      }
    }
    sn.close(); // close input 
  }


  public static void readFile(String fileInput, String[] names, int[] studentID, double[] marks){
    try{
      FileInputStream file = new FileInputStream(fileInput); // create obj for the input stream
      InputStreamReader isr = new InputStreamReader(file); // create obj to read the data stream
      BufferedReader br = new BufferedReader(isr); // more efficient reader than isr
      String line;

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
      br.close();// close reader to save up resources
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
      System.out.println((i+1) + "   " + names[i] + "   " + studentID[i] + "   " + marks[i]);
    }
  }


  public static void writeFile(String[] names, int[] studentID, double[] marks, String fileInput, int numStudent){
    try{
      FileOutputStream file = new FileOutputStream(fileInput, true); // create obj for the output stream
      OutputStreamWriter osw = new OutputStreamWriter(file); // create obj to write to the data stream
      PrintWriter pw = new PrintWriter(osw); // more efficient writer than than osw

      String name;
      int id;
      double mark;
      boolean continueLoop = true;
      Scanner sn = new Scanner(System.in);

      while (continueLoop){
          // if num student exceed 20 then won't add anymore student
          if (numStudent == 20){ // numStudent = lineNum, same thing
            System.out.println("Cannot add new student, storage is full");
            continueLoop = false;
          }
          else{
            System.out.print("Enter student name: ");
            name = sn.next();
            System.out.print("Enter student ID: ");
            id = sn.nextInt();
            System.out.print("Enter mark student got: ");
            mark = sn.nextDouble();

            if (!name.trim().isEmpty() && (id >= 10000000 && id <= 99999999) && (mark >= 0 && mark <= 100)){
              System.out.println("Inserting data to file...");
              // adding data row to parrallel array --> prevent the need to re-load the file again
              names[numStudent] = name;
              marks[numStudent] = mark;
              studentID[numStudent] = id;

              // update the file 
              pw.println(name+","+id+","+mark);
              lineNum += 1;
              pw.close(); // close writer to save up resources
              continueLoop = false;
            }
            else{
              System.out.println("Invalid data format. Try again");
            }
          }
        }
      }
    catch(Exception e){
      System.out.println("Unexpected error occur:" + e);
    }
  }



  public static double avgMark(String[] names, double[] marks, int lineNum){
    double sum = 0;
    for (int i =0; i<lineNum; i++){
      // filter out row that invalid
      if (names[i] == null){
        System.out.println("Ignore invalid row, will not count towards average");
      }
      else{
        sum = sum + marks[i];
      }
    }
    return sum/lineNum;
  }

}
