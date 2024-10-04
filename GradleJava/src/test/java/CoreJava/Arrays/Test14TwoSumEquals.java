package CoreJava.Arrays;

import java.util.HashMap;

 class Test14TwoSumEqualsK{

    public static void main(String[] args) {
        int[] arr = {5,6,7,8};
        int k = 11;

        int[] result = findTwoSum(arr, k);

        if (result != null) {
            System.out.println("Pair found at indices: " + result[0] + " and " + result[1]);
            System.out.println("Numbers are: " + arr[result[0]] + " and " + arr[result[1]]);
        } else {
            System.out.println("No pair found for" +k);
        }
    }

    public static int[] findTwoSum(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = k - arr[i];

            if (map.containsKey(complement)) {
                return new int[] {
                        map.get(complement), i
                };
            }

            map.put(arr[i], i);
        }

        return null;
    }
}


