import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class bubbleSort {


    public static void main(String[] args) {

        List<Integer> unSorted= Arrays.asList(1,2,3,5,4,0,5,7,1);
        int n = unSorted.size();
        for(int i=0;i<n-1;i++){
            for(int j=1; j<n;j++){
                if (unSorted.get(j-1) > unSorted.get(j)){
                    Collections.swap(unSorted,j-1,j);
                }
            }
        }
        System.out.println(unSorted);
    }



}
