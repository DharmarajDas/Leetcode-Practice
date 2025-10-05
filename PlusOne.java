/*
Problem: Plus One
Difficulty: Easy
Link: https://leetcode.com/problems/plus-one/

Approach 1: Basic (Simple Logic)
1. Start from the last digit.
2. Add 1 to it.
3. If it becomes 10, set it to 0 and move to the previous digit.
4. Continue until there is no carry left.
5. If all digits were 9, create a new array with one extra digit (e.g., [9,9,9] -> [1,0,0,0]).
Time Complexity: O(n)
Space Complexity: O(1)

Approach 2: Optimized (Early Return)
1. Similar to Approach 1 but returns immediately when no carry is generated.
2. Avoids unnecessary iterations once the addition is complete.
Time Complexity: O(n)
Space Complexity: O(1)
*/

public class PlusOne {

    // Approach 1: Basic approach
    public int[] plusOneBasic(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }

        if (carry == 1) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
        return digits;
    }

    // Approach 2: Optimized approach (Early return)
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        // If all digits were 9 (like 999 -> 1000)
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}
