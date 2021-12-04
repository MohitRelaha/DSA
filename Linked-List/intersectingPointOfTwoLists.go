/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func GetIntersectionNode(headA, headB *ListNode) *ListNode {
    headA, headB = makeDistanceEqual( headA, headB)
    return getIntersectingNode(headA, headB)
}

func getIntersectingNode(headA, headB *ListNode) *ListNode {
    for headA != nil && headB != nil {
        if headA == headB {
            return headA
        }
        
        headA = headA.Next
        headB = headB.Next
    }
    
    return nil
}

func makeDistanceEqual(headA, headB *ListNode) (*ListNode, *ListNode) {
    l1 := getListLength(headA)
    l2 := getListLength(headB)
    
    if l1 == l2 {
        return headA, headB
    }
    
    if l1 > l2 {
        headA = moveNAhead(headA, l1-l2)
    } else {
        headB = moveNAhead(headB, l2-l1)
    }
    
    return headA, headB
}

func getListLength(head *ListNode) (l int) {
    // 2 pointers approach can be used.
    for head != nil {
        l++
        head = head.Next
    }
    
    return
}

func moveNAhead(head *ListNode, n int) *ListNode {
    for head != nil && n > 0 {
        n--
        head = head.Next
    }
    
    return head
}
