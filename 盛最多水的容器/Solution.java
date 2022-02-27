class Solution {
    public int maxArea(int[] height) {
        //双指针
        int left = 0, right = height.length - 1;

        //定义返回值
        int result = 0;
        while (left < right) {
            int area = Math.min(height[left],height[right]) * (right - left);

            result = Math.max(result,area);

            if (height[left] > height[right]) {
                --right;
            } else {
                ++left;
            }
        }

        return result;
    }
}