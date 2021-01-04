/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 *
 * https://leetcode.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (46.11%)
 * Total Accepted:    3.7M
 * Total Submissions: 8M
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 *
 * Example 2:
 *
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 *
 *
 * Example 3:
 *
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 *
 *
 * Constraints:
 *
 *
 * 2 <= nums.length <= 10^3
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 * Only one valid answer exists.
 *
 *
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int compliment;

        for (int i = 0; i < nums.length; i++) {
            // Get the complement num of current value
            compliment = target - nums[i];
            for (int j = 0; j < nums.length; j++) {
                // Make sure not counting itself and is the complement
                if (i != j && nums[j] == compliment) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        // No result found
        return result;
    }
}
