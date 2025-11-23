import java.util.Arrays;

public class MinimumNumberofArrowstoBurstBalloons {
 // sort by end to know which is finishing first
//    Input: points = [[10,16],[2,8],[1,6],[7,12]]
//    Output: 2
//    Explanation: The balloons can be burst by 2 arrows:
//            - Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
//            - Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        // Sort balloons by their end coordinate
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int lastEnd = points[0][1];

        for (int[] balloon : points) {
            // If next balloon starts after current arrow end → need new arrow
            if (balloon[0] > lastEnd) {
                arrows++;
                lastEnd = balloon[1];
            }
        }
        return arrows;
    }
}
