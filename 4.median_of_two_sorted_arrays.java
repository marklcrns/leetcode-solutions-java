/**
 * Resources:   https://www.youtube.com/watch?v=lLFDQCDzfpI
 *              https://www.geeksforgeeks.org/merge-two-sorted-arrays/
 */
class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		// Ensure nums1 is always shorter than nums2 for simplicity
		if (nums1.length > nums2.length) {
			int[] tmp = nums1;
			nums1 = nums2;
			nums2 = tmp;
		}

		// Init pointers for partitions.
		// lo, will start at the first index
		// hi, will start at the end of nums1 as if the first index of nums2
		int lo = 0;
		int hi = nums1.length;
		int combinedLen = nums1.length + nums2.length;

		// Loop until both pointers meet
		while (lo <= hi) {
			// nums1 being the shortest array, midX represents mid index of nums1
			// midX = the mid index of nums1
			// midY = the mid index of nums2
			//
			// Example 1
			//
			// nums1: [1, 3]
			//         ↑ midX
			// nums2: [2]
			//         ↑ midY
			//
			// Combined sorted: [1, 2, 3]
			//              midX ↑  ↑ midY
			//
			// Example 2
			//
			// nums1: [1, 2]
			//         ↑ midX
			// nums2: [3, 4]
			//         ↑ midY
			//
			// Combined sorted: [1, 2, 3, 4, 5]
			//              midx ↑     ↑ midY
			//

			// System.out.println("lo: " + lo + ",\t\t\thi: " + hi);
			int midX = (lo + hi) / 2;
			int midY = (combinedLen + 1) / 2 - midX;

			// System.out.println("midX: " + midX + ",\t\tmidY: " + midY);

			// getMax and getMin ensures that even when we are at the ends of the
			// arrays, we still get a value that will not mess up the array while
			// preventing index out of bounds.
			int leftX = getMax(nums1, midX);
			int rightX = getMin(nums1, midX);

			// System.out.println("leftX: " + leftX + ",\trightX: " + rightX);

			int leftY = getMax(nums2, midY);
			int rightY = getMin(nums2, midY);

			// System.out.println("leftY: " + leftY + ",\t\trightY: " + rightY);

			// If both pointers crosses or met each other. Meaning we are at the
			// middle of the combined sorted arrays.
			if (leftX <= rightY && leftY <= rightX) {
				// Handle even length
				if (combinedLen % 2 == 0)
					return (Math.max(leftX, leftY) + Math.min(rightX, rightY)) / 2.0;
				else
					return Math.max(leftX, leftY);
			}

			// Scoot over pointers if median not yet found
			if (leftX > rightY)
				hi = midX - 1;
			else
				lo = midX + 1;
		}

		// Return -1 if not sorted or failed
		return -1;
	}

	// Returns the value BEFORE (let) the given idx or NEGATIVE_INFINITY if
	// idx < 0
	private int getMax(int[] nums, int idx) {
		if (idx == 0) {
			return (int)Double.NEGATIVE_INFINITY;
		} else {
			return nums[idx - 1];
		}
	}

	// Returns the value AFTER (right) the given idx or POSITIVE_INFINITY if
	// idx == nums.length
	private int getMin(int[] nums, int idx) {
		if (idx == nums.length) {
			return (int)Double.POSITIVE_INFINITY;
		} else {
			return nums[idx];
		}
	}
}
