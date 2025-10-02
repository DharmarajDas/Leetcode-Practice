/*
Problem: Two Sum
Difficulty: Easy
Link: https://leetcode.com/problems/two-sum/

Approach 1: Brute Force
1. Use two nested loops to check every pair of numbers.
2. If the sum of a pair equals the target, return their indices.
3. Time Complexity: O(n^2)
4. Space Complexity: O(1)

Approach 2: Optimized using HashMap
1. Create a HashMap to store numbers and their indices.
2. Iterate through the array:
   - For each number, calculate complement = target - nums[i].
   - If complement exists in the map, return [map.get(complement), i].
   - Otherwise, store nums[i] in the map with its index.
3. Time Complexity: O(n)
4. Space Complexity: O(n)
*/

import java.util.*;

public class TwoSum {

    // Approach 1: Brute Force
    public int[] twoSumBruteForce(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return new int[]{};
    }

    // Approach 2: Optimized using HashMap
    public int[] twoSumOptimized(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    // Example main method to test both approaches
    public static void main(String[] args) {
        TwoSum sol = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        System.out.println("Brute Force Result: " + Arrays.toString(sol.twoSumBruteForce(nums, target)));
        System.out.println("Optimized Result: " + Arrays.toString(sol.twoSumOptimized(nums, target)));
    }
}
