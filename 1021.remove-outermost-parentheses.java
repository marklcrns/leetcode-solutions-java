/*
 * @lc app=leetcode id=1021 lang=java
 *
 * [1021] Remove Outermost Parentheses
 *
 * https://leetcode.com/problems/remove-outermost-parentheses/description/
 *
 * algorithms
 * Easy (78.71%)
 * Total Accepted:    118.2K
 * Total Submissions: 150.1K
 * Testcase Example:  '"(()())(())"'
 *
 * A valid parentheses string is either empty (""), "(" + A + ")", or A + B,
 * where A and B are valid parentheses strings, and + represents string
 * concatenation.  For example, "", "()", "(())()", and "(()(()))" are all
 * valid parentheses strings.
 *
 * A valid parentheses string S is primitive if it is nonempty, and there does
 * not exist a way to split it into S = A+B, with A and B nonempty valid
 * parentheses strings.
 *
 * Given a valid parentheses string S, consider its primitive decomposition: S
 * = P_1 + P_2 + ... + P_k, where P_i are primitive valid parentheses strings.
 *
 * Return S after removing the outermost parentheses of every primitive string
 * in the primitive decomposition of S.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: "(()())(())"
 * Output: "()()()"
 * Explanation:
 * The input string is "(()())(())", with primitive decomposition "(()())" +
 * "(())".
 * After removing outer parentheses of each part, this is "()()" + "()" =
 * "()()()".
 *
 *
 *
 * Example 2:
 *
 *
 * Input: "(()())(())(()(()))"
 * Output: "()()()()(())"
 * Explanation:
 * The input string is "(()())(())(()(()))", with primitive decomposition
 * "(()())" + "(())" + "(()(()))".
 * After removing outer parentheses of each part, this is "()()" + "()" +
 * "()(())" = "()()()()(())".
 *
 *
 *
 * Example 3:
 *
 *
 * Input: "()()"
 * Output: ""
 * Explanation:
 * The input string is "()()", with primitive decomposition "()" + "()".
 * After removing outer parentheses of each part, this is "" + "" = "".
 *
 *
 *
 *
 *
 *
 * Note:
*
*
* S.length <= 10000
* S[i] is "(" or ")"
* S is a valid parentheses string
*
*
*
*
*
*
*
*/
class Solution {
	public String removeOuterParentheses(String S) {
		StringBuilder sb = new StringBuilder();
		// Keep track of opening parentheses
		int open = 0;
		// String buffer
		// Loop over string (in char[] for convenience and perf)
		for (char c : S.toCharArray()) {
			// Detecting an opening '(' will increment open, while detecting closing ')'
			// will decrement open.
			// This way it can keep appending chars into the buf if open > 0 or while
			// the very first opening hasn't found the closing.
			// Very similar to a Stack data structure. Where open is the number of
			// stacked openings, then it pops off from the stack whenever it finds
			// closing.
			if (c == '(') {
				if (open != 0) sb.append(c);
				open++;
			} else if (c == ')') {
				open--;
				if (open != 0) sb.append(c);
			}
		}

		return sb.toString();
	}
}
