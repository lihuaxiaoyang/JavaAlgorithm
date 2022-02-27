class Solution {
    public String convert(String s, int numRows) {
        //如果数据输入行数小于2，则返回当前字符串
        if (numRows < 2) return s;
        /*
        当字符串大于二时间
        */
        //用于存储变换后的字符串
        List<StringBuilder> chageStr = new ArrayList<StringBuilder>();
        //列表初始化
        for (int i = 0;i < numRows;i ++) chageStr.add(new StringBuilder());
        int i = 0,flag = -1;
        //遍历字符串中的数据，同时向列表中添加数据
        for (char c : s.toCharArray()) {
            chageStr.get(i).append(c);
            if(i == 0 || i == numRows - 1) flag *= -1;
            i += flag;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : chageStr) result.append(row);
        return result.toString();
    }
}