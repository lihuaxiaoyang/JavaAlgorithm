public class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;

        if (len == 0){
            return 0;
        }

        int fast = 1;
        int slow = 1;
        while (fast < len){
            if (nums[fast] != nums[fast - 1]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}