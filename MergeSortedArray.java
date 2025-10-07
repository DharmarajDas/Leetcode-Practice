// 🔹 LeetCode 88. Merge Sorted Array
// Problem Link: https://leetcode.com/problems/merge-sorted-array/

/*
🧩 Problem:
You are given two sorted arrays, nums1 and nums2, and two integers m and n, representing 
the number of elements in nums1 and nums2 respectively.
Merge nums2 into nums1 as one sorted array.

The final sorted array should not be returned by the function, 
but stored inside nums1.

Example:
Input: nums1 = [1,2,3,0,0,0], m = 3
       nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
*/


// 🧠 Approach 1: Brute Force
/*
👉 My Thought Process:
- Since nums1 has extra space at the end, I can first copy all elements from nums2 into nums1.
- Then, simply sort the entire nums1 array.
- It’s easy but not efficient because sorting takes extra time.

Time Complexity: O((m + n) log(m + n))
Space Complexity: O(1)
*/

import java.util.Arrays;

class MergeSortedArray_BruteForce {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int j = 0, i = m; j < n; j++) {
            nums1[i] = nums2[j];
            i++;
        }
        Arrays.sort(nums1);
    }
}


// 🧠 Approach 2: Optimized (Two Pointer from End)
/*
👉 My Thought Process:
- Instead of sorting, I compared elements from the end of both arrays.
- Start from the largest elements (nums1[m-1] and nums2[n-1]).
- Fill nums1 from the back (index m+n-1) with the larger value.
- This avoids overwriting important values in nums1.
- Continue until all elements from nums2 are merged.

Time Complexity: O(m + n)
Space Complexity: O(1)
*/

class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // pointer for nums1
        int j = n - 1; // pointer for nums2
        int k = m + n - 1; // pointer for final merged position

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }
}
