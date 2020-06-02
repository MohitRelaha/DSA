import java.util.Scanner;

public class Main {

    public static boolean checkMaxHeap(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            if (i * 2 + 1 < arr.length && arr[i] < arr[i * 2 + 1]) {
                return false;
            }
            if (i * 2 + 2 < arr.length && arr[i] < arr[i * 2 + 2]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        System.out.println(checkMaxHeap(arr));
    }

}
