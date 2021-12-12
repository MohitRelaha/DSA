/**
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Approach: Using 2 pointers
TC: O(N)
SC: O(1)
*/

func trap(height []int) int {
    l := 0
    r := len(height) - 1
    
    leftMax := 0
    rightMax := 0
    
    res := 0
    
    for l <= r {
        if height[l] <= height[r] {
            if height[l] >= leftMax {
                leftMax = height[l]
            } else {
                res += leftMax - height[l]
            }
            
            l++
        } else {
            if height[r] >= rightMax {
                rightMax = height[r]
            } else {
                res += rightMax - height[r]
            }
            
            r--
        }
    }
    
    return res
}
