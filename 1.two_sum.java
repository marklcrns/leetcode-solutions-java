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
