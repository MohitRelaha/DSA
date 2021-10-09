// https://leetcode.com/problems/two-sum/

func twoSum(nums []int, target int) []int {
    numToIndexMap := make(map[int]int)
    
    for i, elem := range nums {
        if j, ok := numToIndexMap[target-elem]; ok {
            return []int{i, j}
        }
        numToIndexMap[elem] = i
    }
    
    return nil
}
