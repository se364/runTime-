import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * The main file allows you to print the data on text file format
 * @author Shah Emran
 * @version 2.0
 * Date: 4/30/2020
 */
public class Main {

    // initialize the fields

    private static final double NANOS_IN_SECOND = 1000000000;
    private static final int MIN = 10000;
    private static final int MAX = 200000;
    private static PrintWriter arraySort;
    private static PrintWriter arrayList;
    private static PrintWriter treeSet;
    private static PrintWriter hashSet;
    private static PrintWriter nestedLoop;

    /**
     * This is the main method of the runtime analysis program
     * @param args it takes the method from runtime and writes on text file
     */
    public static void main(String[] args) {

        try {
            //arraySort = new PrintWriter("Result_A.txt", StandardCharsets.UTF_8);
            arrayList = new PrintWriter("Result_B.txt", StandardCharsets.UTF_8);
            //treeSet = new PrintWriter("Result_C.txt", StandardCharsets.UTF_8);
            //hashSet = new PrintWriter("Result_D.txt", StandardCharsets.UTF_8);
            //nestedLoop = new PrintWriter("Result_E.txt", StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
        }


        RunTime checkDuplicates = new RunTime();
        // Format of the decimal
        DecimalFormat decimal = new DecimalFormat("#.######");

        //Count
        int counter = 0;

        //initialize
        double secondsElapsed = 0.0;

        //Loop through the range given min and max
        for (int i = MIN; i <= MAX; i += MIN) {
            // takes the number and forms an array passed to the method which has a range [1,array.length/2]
            int[] rand = checkDuplicates.randomNum(i);

                //loop through the 5 algorithms
                for (int j = 1; j <= 5; j++) {
                    LocalTime before = LocalTime.now(); //gets the local time before running the method
//                    counter = checkDuplicates.findDuplicatesA(rand);
                    counter = checkDuplicates.findDuplicatesB(rand);
//                    counter = checkDuplicates.findDuplicatesC(rand);
//                    counter = checkDuplicates.findDuplicatesD(rand);
//                    counter = checkDuplicates.findDuplicatesE(rand);
                    double nanosElapsed = Math.abs(ChronoUnit.NANOS.between(LocalTime.now(), before));
                    double convertInSec = (nanosElapsed / NANOS_IN_SECOND); //there are 1000000000 nanoseconds in a second
                    secondsElapsed += convertInSec; //sum the seconds


                }
            //arraySort.println(i + ", " + decimal.format(secondsElapsed ));
            arrayList.println(i+", " +decimal.format(secondsElapsed/500));
            //treeSet.println(i+", " +decimal.format(secondsElapsed/5));
            //hashSet.println(i+", " +decimal.format(secondsElapsed ));
            //nestedLoop.println(i + ", " + decimal.format(secondsElapsed/100 ));
        }


        //arraySort.close();
        arrayList.close();
        //treeSet.close();
        //hashSet.close();
        //nestedLoop.close();
        System.out.println("There are   " + counter + " of duplicates");
    }
}









