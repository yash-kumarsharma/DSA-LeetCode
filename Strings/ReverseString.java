/*
 LeetCode 344: Reverse String
 https://leetcode.com/problems/reverse-string/
 Approach: Two Pointers (O(n))
*/

class ReverseString {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    // Utility to print char array
    private static void printCharArray(char[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("'" + arr[i] + "'" + (i < arr.length - 1 ? "," : ""));
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        ReverseString solution = new ReverseString();
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        solution.reverseString(s);
        printCharArray(s); // Output: ['o','l','l','e','h']
    }
}
