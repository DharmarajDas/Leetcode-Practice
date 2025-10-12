// LeetCode 283. Move Zeroes
// ------------------------------------------------------------
// 🧠 Problem:
// Given an integer array nums, move all 0's to the end of it
// while maintaining the relative order of non-zero elements.
// Must be done in-place without making a copy.
//
// ------------------------------------------------------------
// 💡 Approach 1: Brute Force (Extra Array)
// - Copy all non-zero elements to a new array, then fill remaining with 0s.
// - Copy back to original array.
// - Simple but not in-place.
// - Time: O(n)
// - Space: O(n)
//
// 💡 Approach 2: Two-Pointer (Simple In-Place)
// - Use one pointer `lastNonZeroIndex` to track position for next non-zero element.
// - Traverse array and move all non-zero elements forward.
// - Fill rest of array with 0s.
// - Time: O(n)
// - Space: O(1)
//
// 💡 Approach 3: Optimized Two-Pointer / Swap Approach
// - First find the first 0 (set pointer `j`).
// - Then, whenever a non-zero is found after it, swap nums[i] and nums[j], then increment j.
// - Maintains relative order and is fully in-place.
// - Time: O(n)
// - Space: O(1)
// ------------------------------------------------------------

public class MoveZeroes {

    // Approach 1: Brute Force (Using Extra Array)
    public void moveZeroesBruteForce(int[] nums) {
        int[] result = new int[nums.length];
        int index = 0;

        for (int num : nums) {
            if (num != 0) {
                result[index++] = num;
            }
        }

        // Copy back to original array
        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }

    // Approach 2: Two-Pointer Simple
    public void moveZeroesSimple(int[] nums) {
        int lastNonZeroIndex = 0;

        // Move all non-zero elements forward
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroIndex++] = nums[i];
            }
        }

        // Fill remaining with zeros
        for (int i = lastNonZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    // Approach 3: Optimized Two-Pointer (Swap Method)
    public void moveZeroes(int[] nums) {
        int j = -1;
        // Find first zero
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }

        // No zeros found
        if (j == -1) return;

        // Swap when non-zero found
        for (int i = j + 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
}
