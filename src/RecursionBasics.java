package Recursion;

public class RecursionBasics {

    public static void printTillN(int num1,int num2){
        if(num1>num2) return;


        printTillN(num1,num2-1);
        System.out.println(num2);
    }
    public static void printFromN(int n1,int n2){
        if(n2<n1) return;
        System.out.println(n2);
        printFromN(n1,n2-1);

    }

    public static void sumTillN_parameterized(int i,int sum){
        if(i<1) {
            System.out.println(sum);
            return;
//            return sum;
        }

        sumTillN_parameterized(i-1,sum+i);
    }

    public static int fibo(int n){
        if(n<=1) return n;

        return fibo(n-1) + fibo(n-2);
    }
    public static int sumTillN_functional(int n){

        if(n==0) return 0;

        return n + sumTillN_functional(n-1);
    }

    public static void main(String[] args) {
        int n = 4;
        int sum=0;
//        printTillN(1,n);
//        printFromN(1,n);
        System.out.println(fibo(n));
    }
}
