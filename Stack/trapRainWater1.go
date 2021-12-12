/**
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

TC : O(N)
SC : O(N)
*/

func trap(height []int) int {
    prefixMax := getPrefixMax(height)
    suffixMax := getSuffixMax(height)
    
    res := 0
    for i, val := range height {
        res += getMinInt(prefixMax[i], suffixMax[i]) - val
    }
    
    return res
}

func getPrefixMax(arr []int) []int{
    if len(arr) == 0 {
        return nil
    }
    
    pMax := make([]int, len(arr))
    
    max := arr[0]
    pMax[0] = max
    
    for i:=1; i<len(arr); i++ {
        if arr[i] > max {
            max = arr[i]
        }
        pMax[i] = max
    }
    
    return pMax
}

func getSuffixMax(arr []int) []int {
    if len(arr) == 0 {
        return nil
    }
    
    sMax := make([]int, len(arr))
    
    max := arr[len(arr)-1]
    sMax[len(arr)-1] = max
    
    for i:=len(arr)-1; i>=0; i-- {
        if arr[i] > max {
            max = arr[i]
        }
        sMax[i] = max
    }
    
    return sMax
}

func getMinInt(a, b int) int {
    if a < b {
        return a
    }
    
    return b
}
