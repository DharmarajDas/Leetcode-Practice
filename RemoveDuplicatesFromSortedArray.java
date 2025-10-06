/*
LeetCode Problem: 26. Remove Duplicates from Sorted Array
Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/

🧠 Approaches Included:
1. Brute Force Approach (Using Set)
2. Optimized Two Pointer Approach
*/

import java.util.*;

public class RemoveDuplicatesFromSortedArray {

    // 🧩 Brute Force Approach
    // Time Complexity: O(n log n)
    // Space Complexity: O(n)
    public int removeDuplicatesBruteForce(int[] nums) {
        // Use a LinkedHashSet to keep order and remove duplicates
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int index = 0;
        for (int num : set) {
            nums[index++] = num;
        }

        return set.size();
    }

    // ⚡ Optimized Approach (Two Pointers)
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    // 🧪 Example Usage
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray obj = new RemoveDuplicatesFromSortedArray();
        int[] nums = {1, 1, 2, 2, 3, 4, 4};

        System.out.println("Brute Force Result: " + obj.removeDuplicatesBruteForce(nums.clone()));

        int[] nums2 = {1, 1, 2, 2, 3, 4, 4};
        System.out.println("Optimized Result: " + obj.removeDuplicates(nums2));
    }
}
