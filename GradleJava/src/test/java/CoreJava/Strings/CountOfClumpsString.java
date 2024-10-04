package CoreJava.Strings;

public class CountOfClumpsString {

    static int countOfClump(String str){
        boolean flag = false;
        int clumpCount=0;
        for(int i=0;i<str.length()-1;i++){ //size 4 0->3
            if(str.charAt(i)==str.charAt(i+1)) {
               if(!flag){
                   clumpCount++;
                   flag=true;
               }
            }
            else
                flag=false;

        }
        return clumpCount;
    }

    public static void main(String[] args) {
        String str=  "sssfrrrrrttsufu";
        System.out.println(countOfClump(str));
    }
}
