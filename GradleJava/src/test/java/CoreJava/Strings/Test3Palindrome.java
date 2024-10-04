package CoreJava.Strings;

import org.testng.Assert;

public class Test3Palindrome {
    public static void main(String[] args) {
       String s= "radar";
       String s1="I love india";
       String revStr ="";
       String rev=" ";
       for(int i=s.length()-1;i>=0;i--){
           revStr+=s.charAt(i);
       }
       if(s.equals(revStr))
           Assert.assertEquals(s,revStr);
       for(int i=s1.length()-1;i>=0;i--){
           rev+=s1.charAt(i);
       }
        System.out.println(rev);

    }
}
