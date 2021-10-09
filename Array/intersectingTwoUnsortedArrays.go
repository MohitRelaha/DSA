// https://leetcode.com/problems/intersection-of-two-arrays-ii/

func intersect(nums1 []int, nums2 []int) []int {
    occurenceNums := make(map[int]int)
    var intersectingElems []int
    
    for _, elem := range nums1 {
        occurenceNums[elem] = occurenceNums[elem] + 1
    }
    
    for _, elem := range nums2 {
        if count := occurenceNums[elem]; count == 0 {
            continue
        }
        
        occurenceNums[elem] = occurenceNums[elem] - 1
        intersectingElems = append(intersectingElems, elem)
    }
    
    return intersectingElems
}
