import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class factorialusingRecursion {


    public static int fact(int n){
        if (n==1){return 1;}
        return n*fact(n-1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(fact(n));
    }


}
