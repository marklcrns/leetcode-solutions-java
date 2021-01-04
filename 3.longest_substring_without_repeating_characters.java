/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (31.05%)
 * Total Accepted:    1.9M
 * Total Submissions: 6.1M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string s, find the length of the longest substring without repeating
 * characters.
 *
 *
 * Example 1:
 *
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 *
 * Example 2:
 *
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 *
 * Example 3:
 *
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not
 * a substring.
 *
 *
 * Example 4:
 *
 *
 * Input: s = ""
 * Output: 0
 *
 *
 *
 * Constraints:
 *
 *
 * 0 <= s.length <= 5 * 10^4
 * s consists of English letters, digits, symbols and spaces.
 *
 *
 */

/**
 * Approach:    Sliding Window
 * Resources:   https://www.youtube.com/watch?v=RoRRpF3eCH4
 *              https://www.youtube.com/watch?v=3IETreEybaA
 */
class Solution {

    public int lengthOfLongestSubstring(String s) {
        int ptrCtr = 0, ptrAnc = 0, max = 0;

        HashSet<Character> set = new HashSet<Character>();

        while (ptrCtr < s.length()) {
            // Check if already in the set
            if (!set.contains(s.charAt(ptrCtr))) {
                set.add(s.charAt(ptrCtr));
                ptrCtr++;
                int len = set.size();
                if (len > max)
                    max = len;
            } else {
                set.remove(s.charAt(ptrAnc));
                ptrAnc++;
            }
        }

        return max;
    }

    // Alternative: Solution without HashSet (Slower)
    // public int lengthOfLongestSubstring(String s) {
    //     int ptrCtr = 0, max = 0;
    //     String sub = "";
    //
    //     while (ptrCtr < s.length()) {
    //         // Check if already in the sub
    //         if (sub.indexOf(s.charAt(ptrCtr)) == -1) {
    //             // Concat current char into sub
    //             Character c = s.charAt(ptrCtr);
    //             sub += c.toString();
    //             ptrCtr++;
    //             // Update max length
    //             int len = sub.length();
    //             if (len > max)
    //                 max = len;
    //         } else {
    //             // Remove first char of sub
    //             sub = sub.substring(1, sub.length());
    //         }
    //     }
    //     System.out.println(sub);
    //     return max;
    //  }
}
