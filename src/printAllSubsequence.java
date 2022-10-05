import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class printAllSubsequence {

    public static final int[] res = new int[]{3,1,2};

    public static void printAllSub(int index, ArrayList<Integer> arr){
        if(index == res.length){
            for(int i:arr){
                System.out.print(i);
            }
        }

        arr.add(res[index]);
//            take
        printAllSub(index+1, arr);
//            have to remove the last item
        arr.remove(arr.size()-1);
//            not take
        printAllSub(index+1,arr);

    }
    public static void main(String[] args) {

        printAllSub(0,new ArrayList<Integer>());
    }
}
