/*
Count Occurences of Anagrams 
Given a word pat and a text txt. Return the count of the occurences of anagrams of the word in the text.

Input:
txt = forxxorfxdofr
pat = for
Output: 3
Explanation: for, orf and ofr appears
in the txt, hence answer is 3.
*/


import java.io.*;
import java.util.*;

public class Solution {

    static int countAnagram(String pat, String txt) {

        HashMap < Character, Integer > patMap = new HashMap < > ();
        for (int i = 0; i < pat.length(); i++) {
            char val = pat.charAt(i);
            if (patMap.containsKey(val)) {
                patMap.put(val, patMap.get(val) + 1);
            } else {
                patMap.put(val, 1);
            }
        }

        int patCount = patMap.size();
        int k = pat.length();
        int l, r, result;
        l = r = result = 0;

        while (r < txt.length()) {
            char rVal = txt.charAt(r);
            if (patMap.containsKey(rVal)) {
                patMap.put(rVal, patMap.get(rVal) - 1);
                if (patMap.get(rVal) == 0) {
                    patCount--;
                }
            }

            if (r - l + 1 == k) {
                char leftVal = txt.charAt(l);
                if (patCount == 0) {
                    result++;
                }
                if (patMap.containsKey(leftVal)) {
                    patMap.put(leftVal, patMap.get(leftVal) + 1);
                    if (patMap.get(leftVal) == 1) {
                        patCount++;
                    }
                }
                l++;
            }

            r++;
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = countAnagram(pat, txt);

            System.out.println(ans);
        }
    }
}
