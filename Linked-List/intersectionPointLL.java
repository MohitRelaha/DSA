
import java.util.*;
class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d; 
        next = null;
    }
}
	
 class LinkedList_Intersection
{
    Node head = null;  
	Node tail = null;

public void addToTheLast(Node node) 
{

  if (head == null) {
   head = node;
   tail = head;
  } else {
   
   tail.next=node;
   tail = node;
  }
}


    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	
	 
 
    public static void main(String args[])
    {

     Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 
		 while(t>0)
         {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			int n3 = sc.nextInt();
			LinkedList_Intersection llist1 = new LinkedList_Intersection();
		    LinkedList_Intersection llist2 = new LinkedList_Intersection();
			LinkedList_Intersection llist3 = new LinkedList_Intersection();
			
				int a1=sc.nextInt();
				Node head1= new Node(a1);
				Node tail1= head1;
				llist1.addToTheLast(head1);
				for (int i = 1; i < n1; i++) 
				{
					int a = sc.nextInt(); 
					llist1.addToTheLast(new Node(a));
				}
			
			
				int b1=sc.nextInt();
				Node head2 = new Node(b1);
				Node tail2 = head2;
				llist2.addToTheLast(head2);
				for (int i = 1; i < n2; i++) 
				{
					int b = sc.nextInt(); 
					llist2.addToTheLast(new Node(b));
				}
				
				int c1=sc.nextInt();
				Node head3= new Node(c1);
				Node tail3=head3;
				llist3.addToTheLast(head3);
				for (int i = 1; i < n3; i++) 
				{
					int c = sc.nextInt(); 
					llist3.addToTheLast(new Node(c));
				}
				
				if (tail1 != null)
				tail1.next = head3;
				if (tail2 != null)
				tail2.next = head3;
				
				Intersect obj = new Intersect();
				System.out.println(obj.intersectPoint(llist1.head, llist2.head));
			t--;			
         }
    }
}


class Intersect
{
	int intersectPoint(Node headA, Node headB)
	{
         
         Node first = headA;
         Node second = headB;
         int size1=0,size2=0,count=0;
         while(first != null){
             first = first.next;
             size1++;
         }
         while(second != null){
             second = second.next;
             size2++;
         }
         
         if(size1 > size2){
            first = headA;
            second = headB;
         }
         else{
            first = headB;
            second = headA;
         }
         
         
         int extra = Math.abs(size1-size2);
         
         
         while(count != extra){
             first = first.next;
         }
         
         while(first != second){
             first = first.next;
             second = second.next;
         }
         
         return first.data;
	}
}


