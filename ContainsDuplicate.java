// LeetCode 217. Contains Duplicate
// ------------------------------------------------------------
// 🧠 Problem:
// Given an integer array nums, return true if any value appears
// at least twice in the array, and false if every element is distinct.
//
// ------------------------------------------------------------
// 💡 Approach 1: Brute Force
// - Compare every element with every other element.
// - Time Complexity: O(n²)
// - Space Complexity: O(1)
// - Very slow for large arrays.
//
// 💡 Approach 2: Sorting
// - Sort the array, then check consecutive elements.
// - If two consecutive elements are equal → duplicate found.
// - Time Complexity: O(n log n)
// - Space Complexity: O(1) (if in-place sort)
//
// 💡 Approach 3: HashSet (Optimized)
// - Traverse the array, store each element in a HashSet.
// - If element already exists → duplicate found.
// - Time Complexity: O(n)
// - Space Complexity: O(n)
// - Most efficient and commonly used solution.
// ------------------------------------------------------------

import java.util.*;

public class ContainsDuplicate {

    // Approach 1: Brute Force
    public boolean containsDuplicateBruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // Approach 2: Sorting
    public boolean containsDuplicateSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    // Approach 3: Optimized (HashSet)
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true; // Duplicate found
            }
            set.add(num);
        }
        return false; // No duplicates
    }
}
