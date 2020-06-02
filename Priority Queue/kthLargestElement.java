import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static int kthLargest(int arr[], int k) {
        PriorityQueue < Integer > pq = new PriorityQueue < > ();
        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                pq.add(arr[i]);
            } else {
                if (arr[i] > pq.peek()) {
                    pq.poll();
                    pq.add(arr[i]);
                }
            }
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        int k = s.nextInt();
        System.out.println(kthLargest(arr, k));
    }

}
