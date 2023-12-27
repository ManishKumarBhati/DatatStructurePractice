
/*
16. 3Sum Closest

Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.



Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).

*/


fun main() {
    println(threeSumClosest(intArrayOf(-1, 0, 1, 2, -1, -4), 1))
}

fun threeSumClosest(nums: IntArray, target: Int): Int {

    nums.sort()

    var minDiff = Int.MAX_VALUE
    var res = 0

    for(i in nums.indices){
        var start = i+1
        var end = nums.size - 1

        while(start < end){
            val sum = nums[i] + nums[start] + nums[end]


            val diff = if(target > sum){
                start++
                target - sum
            } else {
                end--
                sum - target
            }
            if(diff < minDiff){
                minDiff = diff
                res = sum
            }
        }
    }

    return res

}