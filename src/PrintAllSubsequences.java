package Recursion;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class PrintAllSubsequences {

    public static void printAllSub(int index, ArrayList<Integer> ds, int[] arr){

        if(index==arr.length){
            for(int i: ds){
                System.out.print(i + "");
            }
            System.out.println();
            return;
        }

        ds.add(arr[index]);
        printAllSub(index+1, ds ,arr);

        ds.remove(ds.size()-1);
        printAllSub(index+1,ds,arr);


    }


    public static void main(String[] args) {
        int[] arr = {3,1,2};

        ArrayList<Integer> ds = new ArrayList<>();
        printAllSub(0,ds, arr);
    }
}
