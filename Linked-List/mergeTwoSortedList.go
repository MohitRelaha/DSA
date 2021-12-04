/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func mergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode {
    if list1 == nil {
        return list2
    }
    if list2 == nil {
        return list1
    }
    var (
        head *ListNode
        prev *ListNode
    )
    
    for list1 != nil && list2 != nil {
        var smallerNode *ListNode
        
        if list1.Val < list2.Val {
            smallerNode = list1
            list1 = list1.Next
        } else {
            smallerNode = list2
            list2 = list2.Next
        }
        
        if prev == nil {
            head = smallerNode
        } else {
            prev.Next = smallerNode
        }
        prev = smallerNode
    }
    
    if list1 != nil {
        prev.Next = list1
    }
    
    if list2 != nil {
        prev.Next = list2
    }
    
    return head
}
