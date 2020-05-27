import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        PQ pq = new PQ();
        int choice = s.nextInt();
        while (choice != -1) {
            switch (choice) {
                case 1: // insert
                    int element = s.nextInt();
                    pq.insert(element);
                    break;
                case 2: // getMax
                    try {
                        System.out.println(pq.getMin());
                    } catch (PriorityQueueException e) {
                        System.out.println(Integer.MIN_VALUE);
                        return;
                    }
                    break;
                case 3: // removeMax
                    try {
                        System.out.println(pq.removeMin());
                    } catch (PriorityQueueException e) {
                        System.out.println(Integer.MIN_VALUE);
                        return;
                    }
                    break;
                case 4: // size
                    System.out.println(pq.size());
                    break;
                case 5: // isEmpty
                    System.out.println(pq.isEmpty());
                default:
                    return;
            }
            choice = s.nextInt();
        }
    }

}

class PriorityQueueException extends Exception {

}

class PQ {

    private ArrayList < Integer > heap;

    public PQ() {
        heap = new ArrayList < Integer > ();
    }

    boolean isEmpty() {
        return heap.size() == 0;
    }

    int size() {
        return heap.size();
    }

    int getMin() throws PriorityQueueException {
        if (isEmpty()) {
            throw new PriorityQueueException();
        }
        return heap.get(0);
    }

    void insert(int element) {
        heap.add(element);
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;

        while (childIndex > 0) {
            if (heap.get(childIndex) < heap.get(parentIndex)) {
                int temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            } else {
                return;
            }
        }
    }


    int getMinChildIndex(int parentIndex) {
        int lChildIndex = parentIndex * 2 + 1; // already checked : it exists
        int rChildIndex = parentIndex * 2 + 2 < size() ? parentIndex * 2 + 2 : lChildIndex;

        int minIndex = heap.get(lChildIndex) < heap.get(rChildIndex) ? lChildIndex : rChildIndex;
        return minIndex;
    }

    int removeMin() throws PriorityQueueException {
        if (isEmpty()) {
            throw new PriorityQueueException();
        }

        int result = getMin();
        heap.set(0, heap.get(size() - 1));
        heap.remove(size() - 1);
        int parentIndex = 0;

        while (parentIndex * 2 + 1 < size()) { // have minimum one child
            int minChildIndex = getMinChildIndex(parentIndex);
            if (heap.get(parentIndex) > heap.get(minChildIndex)) {
                int temp = heap.get(parentIndex);
                heap.set(parentIndex, heap.get(minChildIndex));
                heap.set(minChildIndex, temp);
            } else {
                break;
            }
            parentIndex = minChildIndex;
        }

        return result;
    }
}
