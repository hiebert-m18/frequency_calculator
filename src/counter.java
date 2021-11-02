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

        // find frequencies of numbers
        for (int i = 0; i < freqMAX; i++) {
            for (int j : list) {
                if (j == i+1) {
                    freqs[i]++;
                }// end if
            }// end for
        }// end for

        // ***** Print Formatted Output *****
        for (int i : freqs) {
            System.out.println(i);
        }

        System.out.println();

//        getFreqFromRange(40, 50, freqs);

        getNumsFromFreq(14, freqs, freqMAX);

        // ***** Closing Message *****

        System.out.println();
        System.out.println("end of processing");
        //fout.println("End of Processing");

        // **** close io buffers *****

        //fin.close();
        //fout.close();
    } // end main

    static void getFreqNum(int num, int[] freqList) {
        System.out.println(freqList[num - 1]);
    }// end getFreqNum

    static void getFreqFromRange(int min, int max, int[] freqList) {
        for (int i = min; i <= max; i++) {
            System.out.println(freqList[i-1]);
        }// end for
    }//end getFreqFromRange

    static void getNumsFromFreq(int freq, int[] freqList, int freqMAX) {
        for (int i = 0; i < freqMAX; i++) {
            if (freqList[i] == freq) {
                System.out.println(i+1);
            }//end if
        }//end for
    }// end getNumsFromFreq

} // end FormatTemplate
