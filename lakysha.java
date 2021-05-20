import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * lakysha
 */
public class lakysha {

    public static void main(String[] args) {
        generateCustomerDataFile();
    }
        public static void generateCustomerDataFile(){
        System.out.println("what do you want to annotate");
        Scanner reader = new Scanner(System.in);
        String annotate= reader.nextLine();
        System.out.println("Add the annotation");
        String answer=reader.nextLine();

            try {
              String filepath=annotate;
                FileWriter fw = new FileWriter(filepath, true); // true appends data, false overwrites the file 
                PrintWriter pw = new PrintWriter(fw); //gives output like System.out
                pw.println();
                pw.println(answer );
              
                pw.flush(); 
                pw.close(); // close file stream 
                System.out.println("annotation saved");
            }
            catch (Exception e) {
                System.out.println("annotation not saved");
            }
        }
        
}