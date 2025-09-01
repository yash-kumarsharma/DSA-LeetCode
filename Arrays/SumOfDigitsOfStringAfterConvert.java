/*
 LeetCode 1945: Sum of Digits of String After Convert
 https://leetcode.com/problems/sum-of-digits-of-string-after-convert/
 Approach:
 1. Convert each character to its alphabetical position.
 2. Sum digits of the converted number.
 3. Repeat the digit-sum process k-1 times.
*/

class SumOfDigitsOfStringAfterConvert {
    // Helper to sum digits of a number
    private int sumD(int num) {
        int result = 0;
        while (num > 0) {
            result += num % 10;
            num /= 10;
        }
        return result;
    }

    public int getLucky(String s, int k) {
        int sum = 0;
        for (char ch : s.toCharArray()) {
            int num = ch - 'a' + 1; // convert to alphabet position
            sum += num / 10 + num % 10; // sum digits directly
        }

        for (int i = 1; i < k; i++) {
            sum = sumD(sum);
        }
        return sum;
    }

    // Utility to print result
    private static void printResult(int val) {
        System.out.println(val);
    }

    public static void main(String[] args) {
        SumOfDigitsOfStringAfterConvert solution = new SumOfDigitsOfStringAfterConvert();
        int result = solution.getLucky("leetcode", 2);
        printResult(result); // Output: 6
    }
}
