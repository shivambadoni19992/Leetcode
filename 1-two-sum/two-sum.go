func twoSum(nums []int, target int) []int {

    mpp := make(map[int]int);

    for ind, val := range nums {
        tar := target - val;
        if v, exists := mpp[tar]; exists {
            return []int {v, ind};
        }

        mpp[val] = ind;
    }
    return []int { -1, -1 };
    
}