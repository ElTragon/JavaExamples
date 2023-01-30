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
     * Time Complexity: O(n) linear, this run for each element in the the input
     * Space Complexity: O(n) linear, I made another char array to copy over the
     * chars in the string
     */
    public static String zigZag(String s, int numRows) {
        // StringBuilder was to slow. When ever possible it is best to use some basic
        // data type pre-built in the language

        // int size = s.length();
        // int cycle = (2 * numRows) - 2;
        // StringBuilder sb = new StringBuilder();

        // for (int row = 0; row < numRows; row++) {
        // for (int offset = 0; offset + row < size; offset += cycle) {
        // sb.append(s.charAt(offset + row));

        // if ((row != 0) && (row != numRows - 1) && (offset + cycle - row < size)) {
        // sb.append(s.charAt(offset + cycle - row));
        // }
        // }
        // }

        // return sb.toString();

        if (numRows == 1) {
            return s;
        }

        int size = s.length();
        int cycle = (2 * numRows) - 2;
        char res[] = new char[size];
        int idx = 0;

        for (int row = 0; row < numRows; row++) {
            for (int offset = 0; offset + row < size; offset += cycle) {
                res[idx++] = s.charAt(offset + row);

                if ((row != 0) && (row != numRows - 1) && (offset + cycle - row < size)) {
                    res[idx++] = s.charAt(offset + cycle - row);
                }

                if (idx == size) {
                    return new String(res);
                }
            }
        }

        return new String(res);

    }

    /*
     * Exercise 1.4: Given a 2D matrix, write a function to print the values
     * going back and forth across each row
     *
     * Time Complexity:
     * Space Complexity:
     */
    public static void printBackAndForth(int[][] arr) {
        // INSERT YOUR SOLUTION HERE

        int size = arr.length;

        for (int i = 0; i < size; i += 2) {
            int rowSize = arr[i].length;
            for (int j = 0; j < rowSize; j++) {
                System.out.println(arr[i][j]);
            }

            if ((i + 1) < size) {
                for (int j = arr[i + 1].length - 1; j >= 0; j--) {
                    System.out.println(arr[i + 1][j]);
                }
            }
        }

    }

    /*
     * Exercise 1.5: Given a 2D matrix, write a function to print the values in
     * the matrix in a clockwise spiral from outside to inside
     *
     * Time Complexity:
     * Space Complexity:
     */
    public static void printSpiral(int[][] arr) {
        // INSERT YOUR SOLUTION HERE
        int minCol = 0;
        int minRow = 0;
        int maxRow = arr.length - 1;
        int maxCol = arr[0].length - 1;
        while (true) {
            // Go across the top
            for (int col = minCol; col <= maxCol; col++) {
                System.out.println(arr[minRow][col]);
            }
            if (minRow >= maxRow)
                break;
            minRow++;

            // Go down the right side
            for (int row = minRow; row <= maxRow; row++) {
                System.out.println(arr[row][maxCol]);
            }
            if (minCol >= maxCol)
                break;
            maxCol--;

            // Go across the bottom
            for (int col = maxCol; col >= minCol; col--) {
                System.out.println(arr[maxRow][col]);
            }
            if (minRow >= maxRow)
                break;
            maxRow--;

            // Go up the left side
            for (int row = maxRow; row >= minRow; row--) {
                System.out.println(arr[row][minCol]);
            }
            if (minCol >= maxCol)
                break;
            minCol++;
        }

    }

    /*
     * Exercise 2.1: Given a string, print out all of the substrings
     *
     * Time Complexity:
     * Space Complexity:
     */
    public static void printSubstrings(String s) {
        // INSERT YOUR SOLUTION HERE
        int size = s.length();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j <= size; j++) {
                System.out.println(s.substring(i, j));
            }
        }
    }

    /*
     * Exercise 2.2: Write a function to find all duplicates in an array. The
     * array will contain exactly 1 duplicated value
     *
     * Time Complexity:
     * Space Complexity:
     */
    public static int findDuplicates(int[] arr) {
        // INSERT YOUR SOLUTION HERE

        HashMap<Integer, Boolean> hash_map = new HashMap<Integer, Boolean>();
        int length = arr.length;
        // method One : Linear runtime, and linear space
        // for(int i : arr){
        // if(hash_map.containsKey(i)){
        // return i;
        // }else{
        // hash_map.put(i, true);
        // }
        // }

        // method two N^2 runtime, const space

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (arr[i] == arr[j]) {
                    return arr[i];
                }
            }
        }

        return -1;
    }

    /*
     * Exercise 2.3: Given a sorted array, find every pair of values in the
     * array that sum up to a given target
     *
     * Time Complexity:
     * Space Complexity:
     */
    public static List<int[]> twoSum(int[] arr, int target) {
        // INSERT YOUR SOLUTION HERE

        List<int[]> res = new ArrayList<int[]>();

        int size = arr.length;
        for (int i = 0; i < size; i++) {
            int find = target - arr[i];
            for (int j = i + 1; j < size - 1; j++) {
                if (find == arr[j]) {
                    res.add(new int[] { arr[i], arr[j] });
                }
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        int[] toReverse = new int[] { 1, 2, 3, 4, 5 };
        reverseArray(toReverse);
        System.out.println(Arrays.toString(toReverse));

        System.out.println(removeEven("iloveinterviewprep"));

        System.out.println(zigZag("PAYPALISHIRING", 3));

        int[][] matrix = new int[4][5];
        int val = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = val++;
            }
        }
        printBackAndForth(matrix);

        printSpiral(matrix);
        printSubstrings("raceCar");
        System.out.println(findDuplicates(new int[] { 1, 2, 3, 4, 2 }));
        List<int[]> twoSum = twoSum(new int[] { 1, 2, 2, 2, 3, 4, 5, 6, 6, 6 }, 8);
        for (int[] a : twoSum)
            System.out.println(Arrays.toString(a));
    }
}
