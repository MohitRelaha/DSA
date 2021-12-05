/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func removeNthFromEnd(head *ListNode, n int) *ListNode {
    if head == nil || n < 1 {
        return head
    }
    
    ptr1 := head
    ptr2 := head
    count := 0
    
    // move ptr2 'n' nodes ahead
    for count < n && ptr2 != nil {
        ptr2 = ptr2.Next
        count++
    }
    
    if ptr2 == nil {
        // n is greater than size of list
        // do nothing
        if n > count {
            return head
        }
        // case -> n == size of list
        // delete first node
        return head.Next
    }
    
    // stop at last node
    // ptr1 will be one node behind 'nth' node from end
    for ptr2.Next != nil {
        ptr1 = ptr1.Next
        ptr2 = ptr2.Next
    }
    
    ptr1.Next = ptr1.Next.Next
    return head
}
