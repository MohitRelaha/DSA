/*
Given an array and a positive integer k, find the first negative integer for each and every window(contiguous subarray) of size k.

Input:
2 // No. of testcases
5 // Array size
-8 2 3 -6 10 // Array elems
2 // K
8 // Array size
12 -1 -7 8 -15 30 16 28 // Array elems
3 // K

Output:
-8 0 -6 -6
-1 -1 -7 -15 -15 0
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    static int[] firstNegative(int arr[], int size, int k) {
        int l, r;
        l = r = 0;
        int res_negatives[] = new int[size - k + 1];
        int res_index = 0;
        ArrayList < Integer > temp_negatives = new ArrayList < > ();
        while (r < size) {
            if (arr[r] < 0) {
                temp_negatives.add(arr[r]);
            }
            if (r - l + 1 == k) {
                if (temp_negatives.size() == 0) {
                    res_negatives[res_index++] = 0;
                } else {
                    res_negatives[res_index++] = temp_negatives.get(0);
                    if (arr[l] < 0) {
                        temp_negatives.remove(0);
                    }
                }
                l++;
            }
            r++;
        }
        return res_negatives;
    }

    static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int size = sc.nextInt();
            int arr[] = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }
            int k = sc.nextInt();
            int negatives[] = firstNegative(arr, size, k);
            print(negatives);
        }
    }
}
