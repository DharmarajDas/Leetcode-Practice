// 🔹 LeetCode 169. Majority Element
// Problem Link: https://leetcode.com/problems/majority-element/

/*
🧩 Problem:
Given an array `nums` of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times.

You may assume that the majority element always exists in the array.

Example:
Input: nums = [3,2,3]
Output: 3
*/


// 🧠 Approach 1: Brute Force using HashMap
/*
👉 My Thought Process:
- I thought to count how many times each number appears.
- Using a HashMap, I store frequency for every element.
- The number which appears more than n/2 times is the majority element.
- It’s simple but uses extra memory.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.HashMap;
import java.util.Arrays;

class MajorityElement_HashMap {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > nums.length / 2) {
                return num;
            }
        }
        return -1; // Should never happen if majority always exists
    }
}


// 🧠 Approach 2: Sorting Method
/*
👉 My Thought Process:
- I realized that if the majority element appears more than n/2 times,
  then after sorting, it must be at the middle index.
- So I just sort the array and return nums[n/2].
- It’s short and simple but slightly slower due to sorting.

Time Complexity: O(n log n)
Space Complexity: O(1)
*/

class MajorityElement_Sorting {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}


// 🧠 Approach 3: Moore’s Voting Algorithm (Optimized)
/*
👉 My Thought Process:
- Instead of using extra space or sorting, I can track a "candidate" element.
- If the count becomes 0, I switch to a new candidate.
- For the same number, I increase count; for a different one, I decrease.
- The final candidate will be the majority element.

✅ Most efficient approach.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}
