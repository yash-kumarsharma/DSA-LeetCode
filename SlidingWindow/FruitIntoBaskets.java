import java.util.*;

/**
 * LeetCode 904: Fruit Into Baskets
 *
 * ✅ Approach (Sliding Window + HashMap):
 * - We must collect fruits using only two baskets.
 * - Each basket can hold only one type of fruit.
 * - So the window must contain at most 2 distinct fruit types.
 *
 * Steps:
 * 1. Use two pointers (l and r) to represent a sliding window.
 * 2. Use a HashMap to store fruit type -> frequency in the window.
 * 3. Expand the window by moving r and adding fruits[r] to the map.
 * 4. If the map size becomes greater than 2:
 *      - Shrink the window from the left.
 *      - Decrease frequency of fruits[l].
 *      - Remove it from map if frequency becomes 0.
 * 5. Update the maximum window length whenever map size ≤ 2.
 *
 * This ensures we always maintain a valid window containing
 * at most two fruit types.
 *
 * ✅ Time Complexity:
 * O(n) — Each element is visited at most twice.
 *
 * ✅ Space Complexity:
 * O(1) — Map stores at most 2 fruit types.
 *
 * Example:
 * Input: fruits = [1,2,1]
 * Output: 3
 *
 * Input: fruits = [0,1,2,2]
 * Output: 3
 */

public class FruitIntoBaskets {

    public int totalFruit(int[] fruits) {
        int l = 0, r = 0, maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (r < fruits.length) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);

            if (map.size() > 2) {
                map.put(fruits[l], map.get(fruits[l]) - 1);

                if (map.get(fruits[l]) == 0) {
                    map.remove(fruits[l]);
                }
                l++;
            }

            if (map.size() <= 2) {
                maxLen = Math.max(maxLen, r - l + 1);
            }

            r++;
        }

        return maxLen;
    }

    // ---- Local Testing ----
    public static void main(String[] args) {
        FruitIntoBaskets sol = new FruitIntoBaskets();

        int[] fruits1 = {1, 2, 1};
        System.out.println(sol.totalFruit(fruits1)); // Expected: 3

        int[] fruits2 = {0, 1, 2, 2};
        System.out.println(sol.totalFruit(fruits2)); // Expected: 3

        int[] fruits3 = {1, 2, 3, 2, 2};
        System.out.println(sol.totalFruit(fruits3)); // Expected: 4
    }
}