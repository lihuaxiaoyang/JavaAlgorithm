/*
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        //传入字符串的预筛选
        if (strs == null || strs.length == 0) {
            return "";
        }

        //记录初始数组中最小公约字符串的长度
        int minLen = Integer.MAX_VALUE;
        //记录数组长度
        int arrLen = strs.length;

        //计算数组中最小公约字符串的长度
        for (String s : strs) {
            if (s.length() < minLen) {
                minLen = s.length();
            }
        }

        for (int i = 0; i < minLen; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < arrLen; j++) {
                if (c != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0].substring(0, minLen);
    }
}