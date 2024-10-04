package CoreJava.Strings;

public class SwapTwoStrings {
    public static void main(String[] args) {
        String a="hello";
        String b="world";
        a=a+b; //helloworld
        b=a.substring(0,a.length()-b.length()); //5,hello
        a=a.substring(b.length());
        System.out.println("after swap :"+ a+" "+ b);
    }
}
