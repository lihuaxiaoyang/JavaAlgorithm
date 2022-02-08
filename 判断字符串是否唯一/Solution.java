class Solution1 {
    //方式一：暴力拆解
    public boolean isUnique(String astr) {
        int strLength = astr.length();
        char[] astrChar = astr.toCharArray();
        for (int i = 0; i < strLength; i++) {
            for (int j = i + 1; j < strLength; j++) {
                if (astrChar[i] == astrChar[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

class Solution2 {
    //方式二：HashMap
    public boolean isUnique(String astr) {
        int astrLength = astr.length();
        char[] astrChar = astr.toCharArray();
        //创建空的HashMap结构，利用Map结构key唯一的特点判断值是否为
        Map<Character, Integer> astrMap = new HashMap<>();
        for (int i = 0; i < astrLength; i++) {
            if (astrMap.containsKey(astrChar[i])) {
                return false;
            }
            astrMap.put(astrChar[i], i);
        }
        return true;
    }
}