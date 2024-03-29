/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 *
 * https://leetcode.com/problems/maximum-subarray/description/
 *
 * algorithms
 * Easy (47.75%)
 * Total Accepted:    1.3M
 * Total Submissions: 2.8M
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 *
 * Example 2:
 *
 *
 * Input: nums = [1]
 * Output: 1
 *
 *
 * Example 3:
 *
 *
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= nums.length <= 3 * 10^4
 * -10^5 <= nums[i] <= 10^5
 *
 *
 *
 * Follow up: If you have figured out the O(n) solution, try coding another
 * solution using the divide and conquer approach, which is more subtle.
 */
class Solution {
  public int maxSubArray(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    int sum = nums[0];
    int total = 0;
    for (int i = 1 ; i < nums.length; i++){
      total = total + nums[i];
    }

    Integer runningSum = sum;

    for (int i = 1 ; i < nums.length; i++) {
      if (sum + nums[i] < nums[i]) {
        sum = nums[i];
      } else {
        sum += nums[i];
      }
      if(sum > runningSum) {
        runningSum = sum;
      }
    }

    if (runningSum > total) {
      return runningSum;
    }

    return total;
  }

}
