// https://leetcode.com/problems/maximum-subarray/

func maxSubArray(nums []int) int {
    sum := nums[0]
    max := nums[0]
    for i:=1 ; i<len(nums) ; i++ {
        if nums[i] + sum >= nums[i] {
            sum += nums[i]
        } else {
            sum = nums[i]
        }
        
        if sum > max {
            max = sum
        }
    }
    
    return max
}
