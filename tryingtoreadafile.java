import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class tryingtoreadafile {
   public static void main(String[] args) {
       Scanner sc=new Scanner (System.in);
       String filename=sc.nextLine();


   } 
   public ArrayList<String> read(String filename){
       ArrayList<String> lines= new ArrayList<String>();
try{
    BufferedReader f=new BufferedReader(new FileReader(filename));
    String s;
    while((s=f.readLine())!=null){
lines.add(s);
    }
}catch(Exception e){
    System.out.println("error occured");
}
return lines;
   }
  
}
