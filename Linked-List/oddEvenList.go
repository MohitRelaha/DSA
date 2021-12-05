/**
Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
The first node is considered odd, and the second node is even, and so on.
Note that the relative order inside both the even and odd groups should remain as it was in the input.

e.g : 
Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]

e.g: 
Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]

*/




// Approach 1: Two Pointers
func oddEvenList(head *ListNode) *ListNode {
    if head == nil || head.Next == nil || head.Next.Next == nil{
        return head
    }
    
    odd := head
    even := head.Next
    evenHead := head.Next
    
    for even != nil && even.Next != nil {
        odd.Next = odd.Next.Next
        even.Next = even.Next.Next
        odd = odd.Next
        even = even.Next
    }
    
    odd.Next = evenHead
    return head
}


// Approach 2: 
// straightforward approach
// maintaining even and odd list
// then joining them
func oddEvenList1(head *ListNode) *ListNode {
    if head == nil || head.Next == nil {
        return head
    }
    
    var (
        oddHead *ListNode
        oddTail *ListNode
        evenHead *ListNode
        evenTail *ListNode
    )
    
    cur := head
    turn := true
    for cur != nil {
        next := cur.Next
        cur.Next = nil
        
        if turn {
            if oddHead == nil {
                oddHead = cur
            } else {
                oddTail.Next = cur
            }
            oddTail = cur
        } else {
            if evenHead == nil {
                evenHead = cur
            } else {
                evenTail.Next = cur
            }
            evenTail = cur
        }
        
        cur = next
        turn = !turn
    }
    
    
    oddTail.Next = evenHead
    return oddHead
}
