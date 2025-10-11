// LeetCode 268. Missing Number
// ------------------------------------------------------------
// 🧠 Problem:
// Given an array nums containing n distinct numbers in the range [0, n],
// return the only number in the range that is missing from the array.
//
// ------------------------------------------------------------
// 💡 Approach 1: Mathematical Formula (Sum of first N numbers)
// - Use formula n*(n+1)/2 and subtract array sum.
// - Time: O(n), Space: O(1)
//
// 💡 Approach 2: Cyclic Sort
// - Put each number at its correct index.
// - The index with mismatch is the missing number.
// - Time: O(n), Space: O(1)
//
// 💡 Approach 3: XOR Method (Optimized)
// - XOR all array elements and all indices [0..n].
// - The remaining number after all XORs is the missing one.
// - Time: O(n), Space: O(1)
// ------------------------------------------------------------

public class MissingNumber {

    // Approach 1: Mathematical Summation
    public int missingNumberSum(int[] nums) {
        int N = nums.length;
        int totalSum = (N * (N + 1)) / 2;
        int arraySum = 0;
        for (int num : nums) arraySum += num;
        return totalSum - arraySum;
    }

    // Approach 2: Cyclic Sort
    public int missingNumberCyclicSort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i];
            if (nums[i] < nums.length && nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }

        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index) {
                return index;
            }
        }
        return nums.length;
    }

    private void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

    // Approach 3: XOR Method
    public int missingNumber(int[] nums) {
        int xor = 0;
        int n = nums.length;

        // XOR all indices and all numbers
        for (int i = 0; i < n; i++) {
            xor ^= i ^ nums[i];
        }

        // XOR with n (last index)
        return xor ^ n;
    }
}
