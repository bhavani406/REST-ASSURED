package CoreJava.Arrays;

import java.util.ArrayList;
import java.util.List;


// here we are comparing array elements  by comparing each element with the elements that came before it.
//outer loop i, inner loop j , j<i , if 2=2 break flag true avoid uncessary checks
//we are adding elements when flag is false
public class Test9RemoveDupWithoutSort {

    static void dupRem(int[] arr,int n){

        List<Integer> list =  new ArrayList<>();
        for(int i=0;i<n-1;i++){
            boolean flag= false;
            for (int j=0;j<i;j++){
                if (arr[i]==arr[j]){
                    flag=true;
                    break;
                }
            }
            // If the element is not a duplicate, add it to the result list
            if (!flag) { //flag==false
                list.add(arr[i]);
            }
        }
        System.out.println(list);

    }

    public static void main(String[] args) {
        int[] arr= {1,2,3,2,1,3,3,4,5,4};
        dupRem(arr,arr.length);

    }
}
