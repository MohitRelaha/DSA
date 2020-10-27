import java.util.Scanner;

public class KElement {
    public static int kthElement(int arr[], int start, int end, int k) {
        int pivot = getPivot(arr, start, end);
        if (pivot == k) {
            return arr[pivot];
        } else if (pivot > k) {
            return kthElement(arr, start, pivot - 1, k);
        }
        return kthElement(arr, pivot + 1, end, k);
    }
    public static int getPivot(int arr[], int start, int end) {
        int randomIndex = (int)(Math.random() * (end - start));
        swap(arr, start + randomIndex, end);
        int pivotElement = arr[end];
        int index = start;
        for (int i = start; i <= end; i++) {
            if (arr[i] <= pivotElement) {
                swap(arr, i, index);
                index++;
            }
        }
        return index - 1;
    }
    public static void swap(int arr[], int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
    public static int kthSmallest(int arr[], int k) {
        return kthElement(arr, 0, arr.length - 1, k - 1);
    }
    public static int kthLargest(int arr[], int k) {
        return kthElement(arr, 0, arr.length - 1, arr.length - k);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        while (testCase-- > 0) {
            int length = sc.nextInt();
            int arr[] = new int[length];
            for (int i = 0; i < length; i++) {
                arr[i] = sc.nextInt();
            }
            int k = sc.nextInt();
            System.out.printf("[%d] smallest element : [%d]\n", k, kthSmallest(arr, k));
            System.out.printf("[%d] largest element : [%d]\n", k, kthLargest(arr, k));
        }
    }
}
