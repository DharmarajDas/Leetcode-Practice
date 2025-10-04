/*
Problem: Remove Element
Difficulty: Easy
Link: https://leetcode.com/problems/remove-element/

Approach 1: Brute Force
1. Use an extra array to store elements that are not equal to the target value.
2. Copy those elements back to the original array.
3. Return the count of valid elements.
Time Complexity: O(n)
Space Complexity: O(n)

Approach 2: Two Pointer (Optimized)
1. Use a pointer `j` to track the position of the next valid element.
2. Iterate through the array using `i`.
3. When nums[i] != val, copy nums[i] to nums[j] and move j forward.
4. Return j as the count of remaining valid elements.
Time Complexity: O(n)
Space Complexity: O(1)
*/

public class RemoveElement {
    // Optimized approach (Two Pointer)
    public int removeElement(int[] nums, int val) {
        int j = 0; // pointer for next position
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    // Brute force approach
    public int removeElementBruteForce(int[] nums, int val) {
        int[] temp = new int[nums.length];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                temp[j++] = nums[i];
            }
        }
        for (int i = 0; i < j; i++) {
            nums[i] = temp[i];
        }
        return j;
    }
}
