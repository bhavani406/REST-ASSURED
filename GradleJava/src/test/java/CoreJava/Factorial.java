package CoreJava;

import java.util.Scanner;

public class Factorial {

    static int factorial(int n){
        int res =1;
        for(int i=1;i<=n;i++){
              res *=i;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number for factorial");
        int n= sc.nextInt();
        System.out.println(factorial(n));
    }
}
