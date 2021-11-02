import java.util.Scanner;
import javax.swing.*;
import java.io.*;
import java.text.NumberFormat;

/** ***************************************************
 *  Name:           Malacai
 *  Class:          CS30S
 *
 *  Assignment:     1.5 Frequency Calculator
 *
 *  Description:    Generate 1000 random numbers and write them to a file
 *
 *************************************************************/

public class number_generator {

    public static void main(String[] args) throws IOException{
        // ***** constants *******
        final int MAX = 1000;

        // ***** variables *****

        String banner = "";             // output banner
        String prompt = "";             // prompt for user input

        String strin = "";              // string fro keyboard input
        String strout = "";             // string for formatted output

        String delim = "[ ]+";          // delimiter for splitting input records
        String[] tokens = null;         // used to split input records

        // a new line character that works on every computer system
        String nl = System.lineSeparator();

        // tracks the amount of numbers generated so far
        int n = 0;

        // ***** objects *****

        //Scanner scanner = new Scanner(System.in);
        //NumberFormat currency = NumberFormat.getCurrencyInstance();

        // file io buffers for reading and writing to text files

        //BufferedReader fin = new BufferedReader(new FileReader("filename.txt"));
        PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("src/data.txt")));

        // ***** print banners *****

        banner = "*****************************" + nl;
        banner += "Name:        Hiebert" + nl;
        banner += "Class:       CS30S" + nl;
        banner += "Assignment:  1.5 Frequency Counter" + nl;
        banner += "*****************************" + nl + nl;

        System.out.println(banner);
        //fout.print(banner);

        // ***** Get Input *****

        // prompt for input
        // read input from keyboard
        // echo input back to console window

        // ***** Main Processing *****
        while (n < MAX) {
            // generate a random number
            int random = (int )(Math.random() * 50 + 1);

            //write random number to file
            fout.println(random);

            n++;                // increment n
        }

        fout.close();

        // ***** Print Formatted Output *****

        // ***** Closing Message *****

        System.out.println();
        System.out.println("end of processing");
        //fout.println("End of Processing");

        // **** close io buffers *****

        //fin.close();
        //fout.close();
    } // end main

} // end FormatTemplate
