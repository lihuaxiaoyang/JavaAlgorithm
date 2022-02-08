class Solution {
    public int reverse(int x) {

        int judge = 1;
        if (x < 0) {
            judge = -1;
            x = x * (-1);
        }
        //直接传int类型的x会初始化StringBuilder的数组长度，因此，需要先将int转为str
        StringBuilder sb = new StringBuilder(String.valueOf(x));

        String reverseStr = sb.reverse().toString();


        //对于超出整数范围的，利用异常进行捕获并放回对应值
        try {
            return judge * Integer.parseInt(reverseStr);
        } catch (Exception e) {
            return 0;
        }

    }
}