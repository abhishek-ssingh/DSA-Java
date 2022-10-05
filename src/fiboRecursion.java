import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class fiboRecursion {


//    time complexity is 2^n
    public static int fibo(int n){


        if (n<=1){return n;}

//        f(n) = f(n-1) + f(n-2)
        int first = fibo(n-1);
        int last = fibo(n-2);

        return first + last;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nth Fibo acc to input");
        int n = scanner.nextInt();
        System.out.println(fibo(n));
    }
}
//0 1 1 2