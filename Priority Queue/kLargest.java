import java.util.Scanner;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int n = s.nextInt();
		int input[] = new int[n];
		for(int j = 0; j < n; j++) {
			input[j] = s.nextInt();
		}
		int k = s.nextInt();
		ArrayList<Integer> output = Solution.kLargest(input, k);
		for(int i : output) {
			System.out.println(i);
		}
		
	}
}

class Solution {

	public static ArrayList<Integer> kLargest(int input[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0;i<input.length;i++){
            if(i<k){
                pq.add(input[i]);
            }else if(pq.peek() < input[i]){
                pq.poll();
                pq.add(input[i]);
            }
        }
        
		ArrayList<Integer> result = new ArrayList<Integer>();
        result.addAll(pq);
        return result;
	}
}
