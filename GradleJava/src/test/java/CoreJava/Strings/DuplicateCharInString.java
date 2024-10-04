package CoreJava.Strings;

import java.util.HashMap;
import java.util.Map;

public class DuplicateCharInString {
    public static void main(String[] args) {
        String str = "welcome to the world";
        String str1 = str.replace(" ","");
        char[] charArray = str1.toCharArray();
        // W=1 e=3
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c: charArray) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }
        // below is to find the duplicate characters in a string
        map.entrySet().stream().filter(entry->entry.getValue()>1).sorted(Map.Entry.comparingByKey()).forEach(x-> System.out.println(x.getKey()));
        //print count of char with number
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(entry -> System.out.println(entry.getKey()+" = "+entry.getValue()));
        //System.out.println(entry.getKey()+" " +entry.getValue());
    }
}
