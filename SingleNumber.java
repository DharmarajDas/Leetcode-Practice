// 🔹 LeetCode 136. Single Number
// Problem Link: https://leetcode.com/problems/single-number/

/*
🧩 Problem:
Given a non-empty array of integers `nums`, every element appears twice except for one. 
Find that single one.

Example:
Input: nums = [4,1,2,1,2]
Output: 4
*/


// 🧠 Approach 1: Using HashMap
/*
👉 My Thought Process:
- I can store each number in a HashMap.
- When a number appears twice, remove it from the map.
- In the end, only the single number will remain in the map.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.HashMap;

class SingleNumber_HashMap {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.remove(num); // Remove if duplicate
            } else {
                map.put(num, 1);
            }
        }

        // The remaining key in the map is the single number
        for (int key : map.keySet()) {
            return key;
        }
        return -1; // This should never happen for valid input
    }
}


// 🧠 Approach 2: Optimized XOR Method
/*
👉 My Thought Process:
- XOR of two same numbers is always 0 (like 2 ^ 2 = 0)
- XOR of 0 with a number gives the number itself (0 ^ 4 = 4)
- So, if I XOR all numbers, all pairs will cancel out, leaving the single number.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class SingleNumber {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num; // cancel out duplicates, keep single one
        }
        return xor;
    }
}
