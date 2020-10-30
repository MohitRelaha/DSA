import java.util.Scanner;

public class Kadane {
    public static void maxSubArraySum(int arr[]) {
        int maxSum = arr[0];
        int tempSum = arr[0];
        int startIndex = 0;
        int tempStartIndex = 0;
        int endIndex = 0;
        int tempEndIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] + tempSum >= arr[i]) {
                tempSum += arr[i];
                tempEndIndex = i;
            } else {
                tempSum = arr[i];
                tempStartIndex = tempEndIndex = i;
            }
            if (tempSum > maxSum) {
                maxSum = tempSum;
                startIndex = tempStartIndex;
                endIndex = tempEndIndex;
            }
        }
        System.out.println("MaxSum : " + maxSum + " [ StartIndex : " + startIndex + " , EndIndex : " + endIndex + " ]");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        while (testCase-- > 0) {
            int size = sc.nextInt();
            int arr[] = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }
            maxSubArraySum(arr);
        }
    }
}
