// 🧩 LeetCode 349: Intersection of Two Arrays
// Problem: https://leetcode.com/problems/intersection-of-two-arrays/
// Level: Easy
// In this problem, we need to find unique common elements between two arrays.

import java.util.*;

public class IntersectionOfTwoArrays {

    // 💡 Approach 1: Brute Force
    // Compare each element of nums1 with nums2.
    // Store unique matches in a set to avoid duplicates.
    // Time Complexity: O(n^2)
    // Space Complexity: O(n)
    public int[] intersectionBruteForce(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    set.add(nums1[i]);
                    break; // no need to check further
                }
            }
        }

        int[] result = new int[set.size()];
        int k = 0;
        for (int num : set) {
            result[k++] = num;
        }

        return result;
    }

    // ⚡ Approach 2: Using HashSet (Efficient)
    // Store elements of nums1 in a HashSet for quick lookup.
    // If nums2 element exists in the set, add to result set.
    // Time Complexity: O(n + m)
    // Space Complexity: O(n)
    public int[] intersectionHashSet(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            if (set1.contains(num)) {
                result.add(num);
            }
        }

        int[] ans = new int[result.size()];
        int i = 0;
        for (int num : result) {
            ans[i++] = num;
        }

        return ans;
    }

    // 🚀 Approach 3: Sorting + Two Pointers
    // Sort both arrays and move pointers to find common elements.
    // Time Complexity: O(n log n + m log m)
    // Space Complexity: O(1) (excluding result)
    public int[] intersectionTwoPointer(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        HashSet<Integer> result = new HashSet<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] ans = new int[result.size()];
        int k = 0;
        for (int num : result) {
            ans[k++] = num;
        }

        return ans;
    }
}
