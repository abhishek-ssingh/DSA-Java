package Recursion;

import java.util.ArrayList;

public class practice {

    public static void printAllSub(int index, ArrayList<Integer> ds, int[] arr){

//        there is a concept of take and not take
        //what we genetrally do is

        if(index==arr.length){
            if(ds.size()==0){
                System.out.println("{}");
                return;
            }

            for(int i: ds){
                System.out.print(i);
            }
            System.out.println();
            return;
        }

//        take
//         Y Y Y
        ds.add(arr[index]);
        printAllSub(index+1,ds,arr);

        ds.remove(ds.size()-1);

//        not take
//        X ............  X X x
        printAllSub(index+1,ds,arr);

    }

    public static void main(String[] args) {

        int[] arr = {3,1,2};
        ArrayList<Integer> ds = new ArrayList<Integer>();
        int index=0;

        printAllSub(index,ds,arr);
    }
}

