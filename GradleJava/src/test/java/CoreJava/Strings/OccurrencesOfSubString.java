package CoreJava.Strings;

public class OccurrencesOfSubString {
    public static int countOfOccurrences(String str, String subStr) {
        int count=0,index = 0;

        while ((index = str.indexOf(subStr, index)) != -1) {
            count++;
            index += subStr.length();
        }

        return count;
    }

    public static void main(String[] args) {
        String str = "cocomelon";
        String subStr = "co";
        int count = countOfOccurrences(str, subStr);
        System.out.println("The substring " +subStr + "  occurs "+count +"times in " +str);
    }


}

