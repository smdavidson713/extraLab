
import java.io.*;
import java.util.*;
  
public class extraLab
{
  public static void main(String[] args) throws FileNotFoundException, IOException
  {
    // 1. opening the file for reading
    FileReader f = new FileReader("Grades.txt");
    BufferedReader in = new BufferedReader(f);
    
    // 2. reading lines of text from the file
    String line = in.readLine();  
    ArrayList<Double> allAverages = new ArrayList<>();
    ArrayList<String> allNames = new ArrayList<>();
    while (line != null) 
    {
      String[] lineArray = line.split(" ");
      double average;
      double sum = 0;
      for(int i=1; i < lineArray.length; i++){
        sum += Integer.parseInt(lineArray[i]);
      }
      average = sum/(lineArray.length-1);
      allAverages.add(average);
      allNames.add(lineArray[0]);
      System.out.println(lineArray[0] + " average: " + average);
      line = in.readLine();
    }
    // 3. closing the file
    f.close(); 

    double max = 0;
    String topStudent = null;
    for(int i=0; i < allAverages.size(); i++){
      if(allAverages.get(i) > max){
        max = allAverages.get(i);
        topStudent = allNames.get(i);
      }
    }

    System.out.println("TOP Student is " + topStudent + " with the highest average grade: " + max);
  }
  
}