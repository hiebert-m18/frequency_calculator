import java.util.Scanner;
import javax.swing.*;
import java.io.*;
import java.text.NumberFormat;

/** ***************************************************
 *  Name:           Hiebert
 *  Class:          CS30S
 *
 *  Assignment:     1.5 Frequency Counter
 *
 *  Description:    Counts the frequency of the numbers in a file
 *
 *************************************************************/

public class counter {

    public static void main(String[] args) throws IOException{
        // ***** constants *******
        final int MAX = 1000;
        final int freqMAX = 50;

        // ***** variables *****

        String banner = "";             // output banner
        String prompt = "";             // prompt for user input

        String strin = "";              // string fro keyboard input
        String strout = "";             // string for formatted output

        String delim = "[ ]+";          // delimiter for splitting input records
        String[] tokens = null;         // used to split input records

        // a new line character that works on every computer system
        String nl = System.lineSeparator();

        int[] list = new int[MAX];          // array for holding the 1000 numbers
        int[] freqs = new int[freqMAX];     // array for holding frequencies
        int n = 0;

        // ***** objects *****

        //Scanner scanner = new Scanner(System.in);
        //NumberFormat currency = NumberFormat.getCurrencyInstance();

        // file io buffers for reading and writing to text files

        BufferedReader fin = null;

        try {
            fin = new BufferedReader(new FileReader("src/data.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        //PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("outfle.txt")));

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
        n = 0;
        strin = fin.readLine();

        while (strin != null && n < MAX) {
            list[n] = Integer.parseInt(strin);

            n++;                    //increment n

            strin = fin.readLine();
        }// end eof

        // how do this more efficiently??
        // find frequencies of numbers
//        for (int i = 0; i < freqMAX; i++) {
//            for (int j : list) {
//                if (j == i+1) {
//                    freqs[i]++;
//                }// end if
//            }// end for
//        }// end for

        // find frequencies of numbers
        for (int i : list) {
            freqs[i - 1] += 1;
        }

        // ***** Print Formatted Output *****
        // frequency of any number
        System.out.println("Frequency of 31 : " + freqs[31 - 1]);          //frequency of 31

        // new line
        System.out.println();

        // frequency of a range of numbers
        System.out.println("The frequencies of the range 10-20");

        int r_min = 10;
        int r_max = 20;
        // get frequencies of the range 10-20
        for (int i = r_min; i <= r_max; i++) {
            System.out.println(i + " : " + freqs[i-1]);
        }// end for

        // new line
        System.out.println();

        // see any range of numbers based on the frequency
        //five most frequent
        System.out.println("The 5 most frequent numbers:");
        // setup temporary array so that I don't wreck original array
        int[] tempArray = new int[freqMAX];
        for (int i = 0; i < freqs.length; i++) {
            tempArray[i] = freqs[i];
        }//end for

        int large[] = new int[5];                       // array to hold five largest
        int max = 0;
        int index;
        for (int j = 0; j < 5; j++) {
            max = tempArray[0];
            index = 0;
            for (int i = 1; i < tempArray.length; i++) {
                // check for largest value
                if (max < tempArray[i]) {
                    max = tempArray[i];
                    index = i;
                }// end if
            }// end for
            large[j] = max;
            tempArray[index] = Integer.MIN_VALUE;

            System.out.println("Largest " + (j+1) +  " : " + large[j]);
        }//end for

        //new line
        System.out.println();

        // five least frequent
        System.out.println("The 5 least frequent numbers:");
        // reset temporary array
        for (int i = 0; i < freqs.length; i++) {
            tempArray[i] = freqs[i];
        }//end for

        int small[] = new int[5];                       // array to hold five largest
        int min = 0;
        for (int j = 0; j < 5; j++) {
            min = tempArray[0];
            index = 0;
            for (int i = 1; i < tempArray.length; i++) {
                // check for largest value
                if (min > tempArray[i]) {
                    min = tempArray[i];
                    index = i;
                }// end if
            }// end for
            small[j] = min;
            tempArray[index] = Integer.MAX_VALUE;

            System.out.println("Smallest " + (j+1) +  " : " + small[j]);
        }//end for


        // new line
        System.out.println();

        // see all numbers that appear n times (or the frequency)
        System.out.println("All the numbers that appear 15 times:");

        int freq = 15;               // n in this case
        for (int i = 0; i < freqMAX; i++) {
            if (freqs[i] == freq) {
                System.out.println(i+1);
            }//end if
        }//end for

        // ***** Closing Message *****

        System.out.println();
        System.out.println("end of processing");
        //fout.println("End of Processing");

        // **** close io buffers *****

        //fin.close();
        //fout.close();
    } // end main

} // end FormatTemplate
