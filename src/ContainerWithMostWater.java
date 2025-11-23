public class ContainerWithMostWater {
        public int maxArea(int[] height) {
            int left = 0, right = height.length - 1;
            int maxArea = 0;

            while (left < right) {
                int h = Math.min(height[left], height[right]);
                int width = right - left;
                int area = h * width;

                maxArea = Math.max(maxArea, area);

                // Move the smaller height inward
                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
            }

            return maxArea;
        }
}
