class Solution {
    //方式一：暴力拆解
    public int[] twoSum(int[] nums, int target) {
        int numsLength = nums.length;
        for (int i = 0; i < numsLength; i++) {
            for (int j = i + 1; j < numsLength; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /*
     * 方式二：HashMap
     * 根据初始值，利用target找寻另一个值
     * */
    public int[] twoSum(int[] nums, int target) {
        int numsLength = nums.length;
        Map<Integer, Integer> numsHashMap = new HashMap<>();
        for (int i = 0; i < numsLength; i++) {
            if (numsHashMap.containsKey(target - nums[i])) {
                return new int[]{numsHashMap.get(target - nums[i]), i};
            }
            numsHashMap.put(nums[i], i);
        }
        return new int[0];
    }
}