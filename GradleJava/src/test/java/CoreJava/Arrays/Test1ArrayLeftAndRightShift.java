package CoreJava.Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Test1ArrayLeftAndRightShift {
// {1,2,3,4,5}
    //left - 3,4,5,1,2
    static void rotateLeft(int[] arr, int d, int n){
        n=arr.length;
        int[] temp =  new int[n];
        int k=0;
// pass elements from d(2) to n-1->  temp[] at the starting at 0 index
        for(int i=d;i<n;i++){
            temp[k]=arr[i];
            k++;
        }
 // pass first 2 elements of arr[] to the last of temp[k]
        for(int i=0; i<d;i++){
            temp[k]=arr[i];
            k++;
        }
 // now pass all temp[] to arr[]
        for (int i=0;i<n;i++ ) {
            arr[i]=temp[i];
        }
 // print the array
        System.out.println("Left shift of the array:  "   +Arrays.toString(arr));
    }

    // {1,2,3,4,5,6}
    //left - 4,5,6,1,2,3
    static void rotateRight(int[] arr, int d, int n){
        n=arr.length;
        int[] temp =  new int[n];
        int k=0;
        int q=n-d;
// pass elements from n-d to temp[] at the starting
        for(int i=q;i<n;i++){
            temp[k]=arr[i];
            k++;
        }
        // pass first 2 elements of arr[] to the last of temp[k]
        for(int i=0; i<q;i++){
            temp[k]=arr[i];
            k++;
        }
        // now pass all temp[] to arr[]
        for (int i=0;i<n;i++ ) {
            arr[i]=temp[i];
        }
        // print the array
        System.out.println("Right shift of the array:  "   +Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {1,2,3,4,5};
        Scanner sc = new Scanner(System.in);
        System.out.println("pls enter the rotation count");
        int d = sc.nextInt();
        rotateLeft(arr1,d,arr1.length);
        rotateRight(arr2,d,arr2.length);

    }

}
