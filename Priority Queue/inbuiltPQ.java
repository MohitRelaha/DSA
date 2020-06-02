import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Collections;

// Swaps on -ve value
class MinComparator implements Comparator<Integer>{
    public int compare(Integer o1,Integer o2){
        //System.out.printf("o1 : %d and o2 : %d\n",o1,o2);
        //return o1-o2;
        
        if(o1 < o2){
            return -1;
        }else if(o1 > o2){
            return 1;
        }else{
            return 0;
        }
        
    }
}

// Swaps on -ve value
class MaxComparator implements Comparator<Integer>{
    public int compare(Integer o1, Integer o2){
        //System.out.printf("o1 : %d and o2 : %d\n",o1,o2);
        //return o2-o1;
        
        if(o1 < o2){
            return 1;
        }else if(o1 > o2){
            return -1;
        }else{
            return 0;
        }
        
    }
}


public class MyClass {
    public static void main(String args[]) {
        MinComparator minCMP = new MinComparator();
        PriorityQueue<Integer> minPQ = new PriorityQueue<>(minCMP);
        minPQ.add(1);
        minPQ.add(2);
        minPQ.add(3);
        minPQ.add(4);
        minPQ.add(5);
        minPQ.add(6);
        minPQ.add(7);
        
        System.out.println("Min PQ");
        while(!minPQ.isEmpty()){
            System.out.print(minPQ.remove() + " ");
        }
        
        System.out.println();
        System.out.println();
        
        MaxComparator maxCMP = new MaxComparator();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(maxCMP);
        maxPQ.add(1);
        maxPQ.add(2);
        maxPQ.add(3);
        maxPQ.add(4);
        maxPQ.add(5);
        maxPQ.add(6);
        maxPQ.add(7);
        
        System.out.println("Max PQ");
        while(!maxPQ.isEmpty()){
            System.out.print(maxPQ.remove() + " ");
        }
        
        
        System.out.println();
        System.out.println();
        
        
        PriorityQueue<Integer> min = new PriorityQueue<>();
        min.add(1);
        min.add(2);
        min.add(3);
        
        System.out.println("Min PQ");
        while(!min.isEmpty()){
            System.out.print(min.remove() + " ");
        }
        
        
        System.out.println();
        System.out.println();
        
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        max.add(1);
        max.add(2);
        max.add(3);
        
        System.out.println("Max PQ");
        while(!max.isEmpty()){
            System.out.print(max.remove() + " ");
        }
        
        
    }
}

/*

Min PQ
1 2 3 4 5 6 7 

Max PQ
7 6 5 4 3 2 1 

Min PQ
1 2 3 

Max PQ
3 2 1 

*/
