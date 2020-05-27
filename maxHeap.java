import java.util.*;

public class Main {

  static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue();
		int choice = s.nextInt();
		while(choice != -1) {
			switch(choice) {
				case 1 : // insert
					int element = s.nextInt();
					pq.insert(element);
					break;
				case 2 : // getMax
					System.out.println(pq.getMax());
					break;
				case 3 : // removeMax
					System.out.println(pq.removeMax());
					break;
				case 4 : // size
					System.out.println(pq.getSize());
					break;
				case 5 : // isEmpty
					System.out.println(pq.isEmpty());
				default :
						return;
			}
			choice = s.nextInt();
		}
	}

}


class PriorityQueue {
    private ArrayList<Integer> heap;
    
    public PriorityQueue(){
          heap = new ArrayList<Integer>();
    }
    
    int getSize(){
        return heap.size();
    }
    
    boolean isEmpty(){
        return heap.size() == 0;
    }
	
    int getMax(){
        if(isEmpty()){
            return Integer.MIN_VALUE;
        }
        return heap.get(0);
    }
    
    void insert(int element){
        heap.add(element);
        int childIndex = heap.size() - 1;
        
        while(childIndex > 0){
            int parentIndex = (childIndex-1)/2;
            if(heap.get(childIndex) > heap.get(parentIndex)){
                int temp = heap.get(childIndex);
                heap.set(childIndex,heap.get(parentIndex));
                heap.set(parentIndex,temp);
            }else{
                return;
            }
            
            childIndex = parentIndex;
        }
    }
    
    int getMaxChild(int parentIndex){
    	  int lChildIndex = parentIndex*2 + 1; 	//already exists
        int rChildIndex = parentIndex*2 + 2 < heap.size() ? parentIndex*2 + 2 : lChildIndex ;
        
        int maxChildIndex = heap.get(lChildIndex) > heap.get(rChildIndex) ? lChildIndex : rChildIndex;
        
        return maxChildIndex;
    }
    
    int removeMax(){
        if(isEmpty()){
            return Integer.MIN_VALUE;
        }
        
        int result = heap.get(0);
        heap.set(0,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        
        int parentIndex = 0;
        
        while(parentIndex*2 + 1 < heap.size()){		// atleast one child is present i.e left child
            int maxChildIndex = getMaxChild(parentIndex);
            
            if(heap.get(maxChildIndex) > heap.get(parentIndex)){
                int temp = heap.get(maxChildIndex);
                heap.set(maxChildIndex,heap.get(parentIndex));
                heap.set(parentIndex,temp);
            }else{
                break;
            }
            
            parentIndex = maxChildIndex;
        }
        
        return result;
    }
}
