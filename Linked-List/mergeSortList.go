/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func sortList(head *ListNode) *ListNode {
    if head == nil || head.Next == nil {
        return head
    }
    
    slow := head
    fast := head.Next
    
    for fast != nil && fast.Next != nil {
        slow = slow.Next
        fast = fast.Next.Next
    }
    
    first := head
    second := slow.Next
    slow.Next = nil
    
    
    first = sortList(first)
    second = sortList(second)
    return merge(first, second)
}

func merge(list1, list2 *ListNode) *ListNode {
    if list1 == nil {
        return list2
    }
    if list2 == nil {
        return list1
    }
    
    var (
        prev *ListNode
        head *ListNode
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
        
        if head == nil {
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
