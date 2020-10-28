import java.util.Scanner;

public class Sort012 {
    public static void sort012(int arr[]) {
        int zeroIndex = -1;
        int twoIndex = arr.length;
        int i = 0;
        while (i < arr.length && arr[i] == 0) {
            zeroIndex++;
            i++;
        }
        i = arr.length - 1;
        while (i >= 0 && arr[i] == 2) {
            twoIndex--;
            i--;
        }
        for (i = zeroIndex + 1; i < twoIndex; i++) {
            if (arr[i] == 0) {
                swap(arr, i, ++zeroIndex);
            } else if (arr[i] == 2) {
                swap(arr, i, --twoIndex);
                i--;
            }
        }
    }
    public static void swap(int arr[], int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
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
            sort012(arr);
            print(arr);
        }
    }
}
