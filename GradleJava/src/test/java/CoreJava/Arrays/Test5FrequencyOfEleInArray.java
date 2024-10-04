package CoreJava.Arrays;

import java.util.HashMap;
import java.util.Map;

public class Test5FrequencyOfEleInArray {

    public static void main(String[] args) {
        int[] arr = {1,2,1,4,4,3,2};
        Map<Integer,Integer> countMap =  new HashMap<>();

        for(int k=0;k<arr.length;k++){
            if(countMap.containsKey(arr[k])){
                countMap.put(arr[k],countMap.get(arr[k])+1);
            }
            else countMap.put(arr[k],1);
        }
        countMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEach(entry-> System.out.println(entry.getKey()+"="+ entry.getValue()));

        //DUPLICATES IN ARRAY
        countMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).filter(entry->entry.getValue()>1)
                .forEach(entry-> System.out.println("Duplicates in array are : "+entry.getKey() +"=" +entry.getValue()));
    }
}
