/**
Problem Statement:
You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order, and each of their nodes contains a single digit. 
Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
*/

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

func newListNode(val int) *ListNode{
    return &ListNode {
        Val: val,
    }
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
    var (
        head *ListNode
        prev *ListNode
        carry int
    )
    
    for l1 != nil || l2 != nil {
        val1, val2 := 0, 0
        if l1 != nil {
            val1 = l1.Val
            l1 = l1.Next
        }
        if l2 != nil {
            val2 = l2.Val
            l2 = l2.Next
        }
        
        sum := val1 + val2 + carry
        value := sum % 10
        carry = sum / 10
        
        newNode := newListNode(value)
        
        if head == nil {
            head = newNode   
        } else {
            prev.Next = newNode
        }
        prev = newNode
    }
    
    if carry != 0 {
        newNode := newListNode(carry)
        prev.Next = newNode
        prev = newNode
    }
    
    return head
}
