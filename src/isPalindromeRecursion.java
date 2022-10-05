import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class isPalindromeRecursion {


    public static boolean isPal(String str,int i){

        int n = str.length();
        if (i>=(n/2)){
//            base case
            return true;
        }
        if (str.charAt(i)==str.charAt(n-i-1)){
            return isPal(str,i+1);
        } else {
            return false;
        }

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Input the n for the sum ");
        List<Integer> list = new ArrayList<Integer>();
        String n = scanner.next();
        System.out.println(isPal(n,0));
    }
}
