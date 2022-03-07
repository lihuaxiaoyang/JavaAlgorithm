package 排序相关;

/**
 * @auther lihua
 * @create 2022-03-05 22:57
 */
public class 数组中只有一个数出现了奇数次 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 1, 15, 15, 15, 31, 31, 31, 2, 2, 2, 2};
        int[] arr2 = new int[]{1, 0, 0, 0};
        int[] arr3 = new int[]{1, 1, 1, 3};
        int[] arr4 = new int[]{3, 3, 3, 7};
        printOddTimeNum2(arr4);
    }

    /*
     * 只有一种数出现了奇数次，其他数出现了偶数次，如何找到这种奇数
     * */
    public static void printOddTimesNum1(int[] arr) {
        int eor = 0;
        for (int cur : arr) {
            eor ^= cur;
        }
        System.out.print(eor);
    }

    /*
     * 只有两种数出现了奇数次，一种数出现了偶数次，如果找到这两种奇数
     * */
    public static void printOddTimeNum2(int[] arr) {
        int eor = 0;
        for (int curNum : arr) {
            eor ^= curNum;
        }

        // eor = a ^ b
        // eor != 0
        // eor 必然有一个位置上不是0
        int rightOne = eor & (~eor + 1);//把某个不等于0的数最后侧的1提取出来

        int onlyOne = 0; //eor'
        for (int cur : arr) {
            if ((cur & rightOne) == 0) {
                onlyOne ^= cur;
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));

    }
}
