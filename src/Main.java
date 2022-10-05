import java.util.*;
import java.util.Scanner;

public class Main {

    public static List<Integer> revArr(List<Integer> arr,int l,int r){

        if (l>=r){return arr;}
        Collections.swap(arr,l,r);

        return revArr(arr,l+1,r-1);
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
        System.out.println(revArr(list,0,list.size()-1));
    }

}
