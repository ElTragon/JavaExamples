import java.util.*;

public class ArraysAndStrings {

    /*
     * Exercise 1.1: Write a function that takes an integer array and reverses
     * the values in place
     *
     * Time Complexity: O(n) linear, the operations run for half of the input.
     * Space Complexity: O(1) constant, the space used does not increase with a
     * larger input
     */
    public static void reverseArray(int[] arr) {

        int arrLength = arr.length;

        for (int i = 0; i < arrLength / 2; i++) {
            int tempValue = arr[i];
            arr[i] = arr[arrLength - 1 - i];
            arr[arrLength - 1 - i] = tempValue;
        }

    }

    /*
     * Exercise 1.2: Write a function that takes in a string and removes every
     * even-indexed character
     *
     * Time Complexity: O(n) linear, runs for half the length of the input
     * Space Complexity: O(n) linear, needs to make a copy for half of the input
     */
    public static String removeEven(String s) {
        // INSERT YOUR SOLUTION HERE
        // strings are inmmutable in Java, but we can make a mutable string like object
        // using stringbuilder
        StringBuilder sb = new StringBuilder();
        int strSize = s.length();

        for (int i = 0; i < strSize; i += 2) {
            sb.append(s.charAt(i));
        }

        return sb.toString();

    }

    /*
     * Exercises 1.3: Zig Zag Conversion
     * Full Problem Definition: https://leetcode.com/problems/zigzag-conversion/
     *
     * Time Complexity:
     * Space Complexity:
     */
    public static String zigZag(String s, int numRows) {
        // INSERT YOUR SOLUTION HERE

        int size = s.length();
        int cycle = (2 * numRows) - 2;
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < numRows; row++) {
            for (int offset = 0; offset + row < size; offset += cycle) {
                sb.append(s.charAt(offset + row));

                if ((row != 0) && (row != numRows - 1) && (offset + cycle - row < size)) {
                    sb.append(s.charAt(offset + cycle - row));
                }
            }
        }

        return sb.toString();

    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        int[] toReverse = new int[] { 1, 2, 3, 4, 5 };
        reverseArray(toReverse);
        System.out.println(Arrays.toString(toReverse));

        System.out.println(removeEven("iloveinterviewprep"));

        System.out.println(zigZag("PAYPALISHIRING", 3));
    }
}
