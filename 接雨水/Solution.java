class Solution {
    public int trap(int[] height) {
        //记录数组长度
        int n = height.length;
        if (n == 0) {
            return 0;
        }

        int[] leftArr = new int[n];
        leftArr[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftArr[i] = Math.max(leftArr[i - 1],height[i]);
        }

        int[] rightArr = new int[n];
        rightArr[n-1] = height[n - 1];
        for (int i = n -2; i >= 0; i--) {
            rightArr[i] = Math.max(rightArr[i + 1],height[i]);
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += Math.min(leftArr[i],rightArr[i]) - height[i];
        }
        return result;
    }
}