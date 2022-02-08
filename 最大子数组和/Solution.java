public class Solution {
    public int maxSubArray(int[] nums) {
        //记录之前和
        int preSum = 0;
        //记录当前和
        int currentSum = 0;
        //记录最大和
        int maxSum = nums[0];

        //遍历数组中的每一个元素
        for (int item : nums) {
            //如果之前和小于零，则计算当前和的时候舍去
            if (preSum < 0) {
                currentSum = item;
                //更新之前和
                preSum = currentSum;
            } else {
                currentSum = preSum + item;
                preSum = currentSum;
            }
            maxSum = Math.max(currentSum, maxSum);
        }

        return  maxSum;
    }
}