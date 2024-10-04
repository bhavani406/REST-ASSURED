package CoreJava.Arrays;

import java.util.ArrayList;

//WE CAN FOLLOW TEST5 AS WELL BUT USING INNER LOOP WE CAN DO LIKE BELOW
//Find duplicates in an array and print
public class Test6DuplicatesInArray {

    static void duplicateEle(int arr[], int len){
        boolean ifPresent = false;
        ArrayList<Integer> al = new ArrayList<Integer>();
        for(int i=0;i<len-1;i++){
            for(int j=i+1;j<len;j++){
                if(arr[i]==arr[j]){
                    if(al.contains(arr[i])) break;
                    else {
                        al.add(arr[i]);
                        ifPresent=true;
                    }
                }
            }
        }
        if(ifPresent){ // ifpresent==true
            System.out.print(al+" ");
        }
        else {
            System.out.print(
                    "No duplicates present in arrays");
        }
    }

    public static void main(String[] args) {
        int[] arr= {1,3,2,1,3,3};
        duplicateEle(arr,arr.length);
    }

}
