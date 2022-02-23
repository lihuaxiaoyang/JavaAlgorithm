import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> strSet = new HashSet<Character>();

        int len = s.length();

        //右指针
        int rk = -1;
        //最长子串长度
        int result = 0;
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                strSet.remove(s.charAt(i - 1));
            }
            while (rk + 1 < len && !strSet.contains(s.charAt(rk + 1))) {
                strSet.add(s.charAt(rk + 1));
                rk++;
            }
            result = Math.max(rk - i + 1,result);
        }
        return result;
    }

}