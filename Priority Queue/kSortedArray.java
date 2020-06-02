import java.util.Scanner;
public class Main {
    
    public static void sortKSorted(int arr[] , int k){
        java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.add(arr[i]);
        }
        for(int i=0;i<arr.length;i++){
            arr[i] = pq.remove();
            
            if(i+k < arr.length){
                pq.add(arr[i+k]);
            }
        }
    }
    
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      int n;    // size of array
      n = sc.nextInt();
      int arr[] = new int[n];
      // Make sure array is K-Sorted
      for(int i=0;i<n;i++){
          arr[i] = sc.nextInt();
      }
      
      int k;    // size of window
      k = sc.nextInt();
      
      sortKSorted(arr,k);
      
      for(int i : arr){
          System.out.print(i + " ");
      }
    }
}


// O(nlogk)
