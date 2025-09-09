import java.util.*;
import java.io.*; // import java packcage for system input/output through data streams & file systems

public class demo{
  public static void main(String[] args) {
    printChar("data.txt");
    
    
  }

  public static void printLine(String fileName){
    try{
      FileInputStream stream = new FileInputStream(fileName);
      InputStreamReader isr = new InputStreamReader(stream);
      BufferedReader bufRdr = new BufferedReader(isr);

      String line = bufRdr.readLine();
      while (line != null){
        System.out.println(line);
        line= bufRdr.readLine();
      }
      stream.close();
    }

    catch (IOException e){ // catch input/output exception
      System.out.println(e.getMessage());
    }
  }

  public static void printChar(String fileName){
    try{
      FileInputStream stream = new FileInputStream(fileName);
      InputStreamReader isr = new InputStreamReader(stream);
      int t;

      while ((t=isr.read())!=-1){
        char r = (char) t; //typecast t as a char 
        System.out.println(r);
      }
      isr.close();
      stream.close();
    }

    catch (IOException e){ // catch input/output exception
      System.out.println(e.getMessage());
    }
  }
}
