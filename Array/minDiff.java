import java.io.*;
import java.util.*;

class Solution {
    int getMinDiff(int[] arr, int n, int k) {
        if (n == 1) {
            return 0;
        }
        Arrays.sort(arr);
        int ans = arr[n - 1] - arr[0];
        int max = arr[n - 1] - k;
        int min = arr[0] + k;
        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
        }
        for (int i = 1; i < n - 1; i++) {
            int subtract = arr[i] - k;
            int add = arr[i] + k;
            if (subtract >= min || add <= max) {
                continue;
            }
            if (max - subtract <= add - min) {
                min = subtract;
            } else {
                max = add;
            }
        }
        return Math.min(ans, max - min);
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().getMinDiff(arr, n, k);
            System.out.println(ans);
        }
    }
}


/*
Given an array arr[] denoting heights of N towers and a positive integer K, modify the heights of each tower either by increasing or decreasing them by K only once. Find out the minimum difference of the heights of shortest and longest modified towers.

Input:
K = 2, N = 4
Arr[] = {1, 5, 8, 10}
Output: 5
Explanation: The array can be modified as 
{3, 3, 6, 8}. The difference between 
the largest and the smallest is 8-3 = 5.
*/
