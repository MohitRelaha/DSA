public class ReverseArray {
    public static void reverseArray(int arr[]) {
        for (int i=0; i<arr.length/2; i++) {
            if (arr[i] != arr[arr.length-1-i]) {
                swap(arr, i, arr.length-1-i);    
            }
        }
    }
    public static void swap(int arr[], int index1, int index2) {
        arr[index1] = arr[index1] ^ arr[index2];
        arr[index2] = arr[index1] ^ arr[index2];
        arr[index1] = arr[index1] ^ arr[index2];
    }
    public static void printArray(int arr[]) {
        for(int element : arr) {
            System.out.print(element + " ");
        }
    }
    public static void main(String args[]) {
        int arr[] = new int[]{5,4,3,2,1};
        reverseArray(arr);
        printArray(arr);
    }
}
