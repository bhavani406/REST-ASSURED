package CoreJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fibonacci {

    static void fibonacci(int n){
        int a=0,b=1;
        for(int i=0;i<n;i++){
            System.out.print(a+" ");
            int next = a+b;
            //System.out.print(next+" ");
            a = b;
            b = next;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number for fibonacci");
        int n= sc.nextInt();
        fibonacci(n);
    }
}
