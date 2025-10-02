/*
Problem: Two Sum
Difficulty: Easy
Link: https://leetcode.com/problems/two-sum/

Approach:
1. Use a HashMap to store numbers and their indices.
2. For each element, calculate complement = target - nums[i].
3. If complement exists in map → return [map.get(complement), i].
4. Otherwise, put nums[i] into map.

Time Complexity: O(n)
Space Complexity: O(n)
*/
import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }
}
