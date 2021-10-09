// https://leetcode.com/problems/merge-sorted-array/

func merge(nums1 []int, m int, nums2 []int, n int)  {
    
    index := len(nums1)-1
    
    // right shift actual elements of nums1
    for i:=m-1 ; i>=0 ; i-- {
        nums1[index] = nums1[i]
        index--
    }
    
    i1 := n
    i2 := 0
    i := 0
    
    for i1<len(nums1) && i2<len(nums2) {
        if nums1[i1] <= nums2[i2] {
            nums1[i] = nums1[i1]
            i1++
        } else {
            nums1[i] = nums2[i2]
            i2++
        }
        i++
    }
    
    for i2<len(nums2) {
        nums1[i] = nums2[i2]
        i++
        i2++
    }
}
