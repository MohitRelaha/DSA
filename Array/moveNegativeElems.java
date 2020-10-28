public class RearrangeNegative {
    public static void rearrangeNegative1(int arr[]) {
        int negativeIndex = -1;
        int i = 0;
        while (arr[i] < 0) {
            negativeIndex++;
            i++;
        }
        for (; i < arr.length; i++) {
            if (arr[i] < 0) {
                swap(arr, i, ++negativeIndex);
            }
        }
    }

    // two pointers approach
    public static void rearrangeNegative2(int arr[]) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            if (arr[left] < 0 && arr[right] < 0) {
                left++;
            } else if (arr[left] > 0 && arr[right] > 0) {
                right--;
            } else if (arr[left] > 0 && arr[right] < 0) {
                swap(arr, left, right);
                left++;
                right--;
            } else {
                left++;
                right--;
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
    }
    public static void main(String args[]) {
        int arr[] = new int[]{ 4, -18, 7, 64, 32, -22, -41, 11, 41, -10, 34 };
        rearrangeNegative2(arr);
        print(arr);
    }
}
