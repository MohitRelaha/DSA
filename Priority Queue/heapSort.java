import java.util.Scanner;

public class Main {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int n = s.nextInt();
        int input[] = new int[n];
        for (int j = 0; j < n; j++) {
            input[j] = s.nextInt();
        }
        Solution.inplaceHeapSort(input);
        for (int i: input) {
            System.out.print(i + " ");
        }
    }
}


class Solution {

    public static void heapify(int input[]) {
        for (int i = 1; i < input.length; i++) {
            int childIndex = i;

            while (childIndex > 0) {
                int parentIndex = (childIndex - 1) / 2;
                if (input[childIndex] < input[parentIndex]) {
                    int temp = input[childIndex];
                    input[childIndex] = input[parentIndex];
                    input[parentIndex] = temp;
                } else {
                    break;
                }

                childIndex = parentIndex;
            }
        }
    }

    public static int getMinChildIndex(int parentIndex, int input[], int size) {
        int lChildIndex = parentIndex * 2 + 1; // already checked : it exists
        int rChildIndex = parentIndex * 2 + 2 < size ? parentIndex * 2 + 2 : lChildIndex;

        int minIndex = input[lChildIndex] < input[rChildIndex] ? lChildIndex : rChildIndex;
        return minIndex;
    }

    public static void heapSort(int input[]) {
        int heapSize = input.length;

        while (heapSize > 1) {
            int temp = input[0];
            input[0] = input[heapSize - 1];
            input[heapSize - 1] = temp;
            heapSize--;

            int parentIndex = 0;
            while (parentIndex * 2 + 1 < heapSize) { // have minimum one child
                int minChildIndex = getMinChildIndex(parentIndex, input, heapSize);
                if (input[minChildIndex] < input[parentIndex]) {
                    temp = input[minChildIndex];
                    input[minChildIndex] = input[parentIndex];
                    input[parentIndex] = temp;
                } else {
                    break;
                }

                parentIndex = minChildIndex;
            }
        }
    }

    public static void inplaceHeapSort(int input[]) {
        heapify(input);
        heapSort(input);
    }
}
