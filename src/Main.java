import java.util.*;
import java.util.Scanner;

public class Main {

    public static List<Integer> revArr(List<Integer> arr,int i){

        int n = arr.size();
        if (i>=(n/2)){
            return arr;
        }

        Collections.swap(arr,i,n-i-1);
        return revArr(arr,i+1);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Input the n for the sum ");
        List<Integer> list = new ArrayList<Integer>();
        int n = scanner.nextInt();
        for(int i=0; i<n;i++){
            int ip = scanner.nextInt();
            list.add(ip);
        }
        System.out.println(revArr(list,0));
    }

}
