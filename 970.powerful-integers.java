import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=970 lang=java
 *
 * [970] Powerful Integers
 *
 * https://leetcode.com/problems/powerful-integers/description/
 *
 * algorithms
 * Easy (39.90%)
 * Total Accepted:    26.4K
 * Total Submissions: 66.1K
 * Testcase Example:  '2\n3\n10'
 *
 * Given two positive integers x and y, an integer is powerful if it is equal
 * to x^i + y^j for some integers i >= 0 and j >= 0.
 *
 * Return a list of all powerful integers that have value less than or equal to
 * bound.
 *
 * You may return the answer in any order.  In your answer, each value should
 * occur at most once.
 *
 *
 *
 *
 * Example 1:
 *
 *
 * Input: x = 2, y = 3, bound = 10
 * Output: [2,3,4,5,7,9,10]
 * Explanation:
 * 2 = 2^0 + 3^0
 * 3 = 2^1 + 3^0
 * 4 = 2^0 + 3^1
 * 5 = 2^1 + 3^1
 * 7 = 2^2 + 3^1
 * 9 = 2^3 + 3^0
 * 10 = 2^0 + 3^2
 *
 *
 *
 * Example 2:
 *
 *
 * Input: x = 3, y = 5, bound = 15
 * Output: [2,4,6,8,10,14]
 *
 *
 *
 *
 *
 *
 * Note:
 *
 *
 * 1 <= x <= 100
 * 1 <= y <= 100
 * 0 <= bound <= 10^6
 *
 */
class Solution {
	public List<Integer> powerfulIntegers(int x, int y, int bound) {
		// Notes:
		// No duplicate values. Use HashSet to collect
		// exponent starts with 0. n^0 = 1
		// List if integers should be <= bound

		// https://leetcode.com/problems/powerful-integers/discuss/296387
		//
		// * Lang:    java
		// * Author:  416486188
		// * Votes:   1
		//
		// **Analysis**
		//
		// This problem is not easy. I think it is one of the pattern where we consider the problem in opposite way: **we are not checking them, we are finding them**.
		//
		// For this problem, the key is that **we are not iterate `[1, bound]` and check if they are valid. Instead we are constructing all valid number in `[1, bound]` and add to result**.
		//
		// It is very similar to the problem **[#204](https://leetcode.com/problems/count-primes)  Count Primes**. We are not checking if each number is prime, we are ruling out all composite number. That\'s the reason why I called it `opposite way`.
		//
		// ---
		// **Strategy**
		//
		// Basically, we are doing brute force, get all combination of `x^c1 + y^c2` who `<= bound`, and their sum is a candidate. Then we add it to the result list `res`.
		//
		// Pseudo code:
		//
		// ```
		// for i = x ^ c1{
		//     for j = y ^ c2{
		//         if( i + j <= bound){
		//            // add to result
		//         }
		//     }
		// }
		// ```
		//
		// **Take care**
		//
		// We need to take care of the case when **x == 1 || y == 1** to avoid infinite loop in contructing the number.

		Set<Integer> set = new HashSet<Integer>();

		int i = 1;
		while (i < bound) {
			int j = 1;
			while (j < bound) {

				int sum = i + j;
				if (sum <= bound)
					set.add(sum);

				j *= y;	// much like y^(n+1) to check the next exponent of y
				if (y == 1) break;
			}

			i *= x; // much like x^(n+1) to check the next exponent of x
			if (x == 1) break;
		}

		return new ArrayList<Integer>(set);
	}
}
