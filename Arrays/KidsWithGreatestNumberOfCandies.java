/**
 * LeetCode 1431: Kids With the Greatest Number of Candies
 *
 * ✅ Approach:
 * - First, find the maximum number of candies any kid currently has.
 * - Then, for each kid, check if:
 *        candies[i] + extraCandies >= max
 * - If yes → true
 * - Otherwise → false
 *
 * ✅ Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(N) (for result list)
 *
 * ✅ Example:
 * candies = [2,3,5,1,3], extraCandies = 3
 * Output = [true,true,true,false,true]
 */

import java.util.*;

public class KidsWithGreatestNumberOfCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();

        int max = 0;
        for (int num : candies) {
            max = Math.max(max, num);
        }

        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= max) {
                list.add(true);
            } else {
                list.add(false);
            }
        }

        return list;
    }

    // ---- Local Testing ----
    public static void main(String[] args) {
        KidsWithGreatestNumberOfCandies sol =
                new KidsWithGreatestNumberOfCandies();

        int[] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;

        System.out.println(sol.kidsWithCandies(candies, extraCandies));
        // Expected: [true, true, true, false, true]
    }
}