/*
 *给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 * */
class Solution {
    public boolean isPalindrome(int x) {
        //方式一：
//        int flag = 1;
//        if( x < 0){
//            return false;
//        }
//
//        char[] temp = String.valueOf(x).toCharArray();
//        int numL = temp.length;
//
//        if (numL % 2 != 0 && numL > 3) {
//            for (int i = 0; i < (numL - 1) / 2; i++) {
//                if (temp[i] != temp[numL - i - 1]) {
//                    return false;
//                }
//            }
//            return true;
//        } else if (numL == 2) {
//            if (temp[0] == temp[1]) {
//                return true;
//            }else{
//                return false;
//            }
//        } else if (numL % 2 == 0 && numL > 2) {
//            for (int i = 0; i < numL / 2; i++) {
//                if (temp[i] != temp[numL - i - 1]){
//                    return false;
//                }
//            }
//            return true;
//        } else if (numL == 1) {
//            return true;
//        } else if(numL == 3){
//            if(temp[0] != temp[2]){
//                return false;
//            }else return true;
//        }else{
//            return true;
//        }
        //方式二：
        /*
         * 特殊情况：
         * 如上所述，当x < 0时，x不是回文数。
         * 同样的，如果数字的最后一位是0，为了使该数字为回文数，
         * 则其第一位数字也应该是0
         * 只有0满足这一属性
         * */
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
