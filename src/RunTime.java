
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Checking duplicates in arrays with five different methods
 * @author Shah Emran
 * @version 1.0
 * Date: 4/29/2020
 */
public class RunTime {


    /**
     * @param input :
     * @return duplicate numbers found in Array with using Array.sort
     */
    public int findDuplicatesA(int[] input){

        Arrays.sort(input);

        int previous = input[0] - 1;

        int dupCount = 0;

        for (int value : input) {
            if (value == previous) {
                ++dupCount;
            } else {
                previous = value;
            }
        }
        return dupCount;

    }


    /**
     * @param input :
     * @return duplicate numbers from array by using ArrayList
     */
    public  int findDuplicatesB(int [] input){
        List<Integer>list = new ArrayList<>();
//        int jar  = 0;
        for(int i = 0; i<input.length-1 ; i++){
            if(!list.contains(input[i])){
                //input[jar] = input[i];
                //jar++
                list.add(input[i]);

            }
//            else if(!list.contains(input[i])){
//                list.add(input[i]);
//            }
        }
        return input.length - list.size();

    }


    /**
     * @param input :
     * @return duplicate number from the array by using treeSet
     */
    public  int findDuplicatesC(int [] input){

        int inputLength = input.length;
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int str : input) {
            if (!treeSet.contains(str)) {
                treeSet.add(str);
            }
        }
        int treeLength  = treeSet.size();
        // finds the number of duplicates
        return inputLength - treeLength;

    }


    /**
     * @param input :
     * @return duplicate number from the array by using hashSet
     */
    public  int findDuplicatesD(int[] input){
        int inputLength = input.length;
        HashSet<Integer> set = new HashSet<>();

        for (int value : input) {
            if (!set.contains(value)) {
                set.add(value);
            }
        }


        int setLength = set.size();
        return inputLength - setLength;

    }


    /**
     * @param input :
     * @return duplicate number from the array by using  nested loops
     */
    public int findDuplicatesE(int [] input){

        int count = 0 ;
        for(int  i = 0 ; i < input.length ; i++) {

            for(int j = i+1 ; j < input.length;j++) {
                if(input[i] == input[j]) {
                    count++ ;
                    break;
                }
            }
        }

        return count;

    }

    /**
     * @param size:
     * @return random numbers are generated within the given range
     */
    public  int[] randomNum(int size){

        Random random = new Random();
        int[] num = new int[size];
        for(int k = 1; k<num.length; k++){

            // The range of the array [1,array.length/2]
            num[k] = random.nextInt(num.length/2);
        }

        return num;



  }


}
