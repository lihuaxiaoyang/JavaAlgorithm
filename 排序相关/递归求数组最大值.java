package 排序相关;

/**
 * @auther lihua
 * @create 2022-03-06 10:12
 */
public class 递归求数组最大值 {

    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    //arr[L..R]范围上求最大值
    public static int process(int[] arr, int L, int R) {
        if (L == R) { //arr[L..R]范围上只有一个数，直接返回，base case
            return arr[L];
        }
        /*
         *
         * mid = (L + R) / 2; 其中L + R 可能溢出
         * mid = L + (R - L) / 2；不会溢出
         *
         * */
        int mid = L + ((R - L) >> 1);//中点
        int leftMax = process(arr, L, mid);
        int rightMax = process(arr, mid + 1, R);
        return Math.max(leftMax, rightMax);
    }


    public static void main(String[] args) {

    }
}
