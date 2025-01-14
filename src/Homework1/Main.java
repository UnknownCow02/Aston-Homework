package Homework1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String string = "I love java";
        turnString(string);

        int[] nums = {1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9};
        getDistinctNumber(nums);

        int[] arr = {10, 15, 23, 11, 44, 13, 66, 1, 6, 47};
        System.out.println("\n" + findSecondMaxElement(arr));

        String text = "    fly me    to the moon       ";
        System.out.println(lengthOfLastWord(text));

        String palindrome = "12321";
        System.out.println(isPalindrome(palindrome));
    }


    // ex 1
    public static void turnString(String string) {
        StringBuilder sb = new StringBuilder(string);
        System.out.println(sb.reverse());
    }

    // ex 2
    public static void getDistinctNumber(int[] nums) {
        int[] result = Arrays.stream(nums).distinct().toArray();
        System.out.print(Arrays.toString(result));
    }


    // ex 3
    public static int findSecondMaxElement(int[] nums) {
        int maxValue = 0;
        int result = 0;

        for (int num : nums) {
            if (num > maxValue) {
                maxValue = num;
            }

            if (num < maxValue) {
                result = num;
            }
        }

        return result;
    }

    // ex 4
    public static int lengthOfLastWord(String string) {
        String[] splitString = string.split(" ");
        int result = 0;

        for (var str : splitString) {
            result = str.length();
        }
        return result;
    }

    // ex 5
    public static boolean isPalindrome(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == string.charAt(string.length() - 1 - i)) {
                return true;
            }
        }
        return false;
    }
}