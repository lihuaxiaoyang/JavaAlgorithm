package 排序相关;

/**
 * @auther lihua
 * @create 2022-03-06 10:58
 */

/*
* 1.尽可能的一组数据拆分成两个元素相等的子组，并对每一个子组继续拆分，直到拆分后的每个子组的元素个数是
1为止。
 2.将相邻的两个子组进行合并成一个有序的大组；
 3.不断的重复步骤2，直到最终只有一个组为止。
*
* */
public class 归并排序 {

    /*
     * 1）整体就是一个简单递归，左边排好序、右边排好序、让其整体有序
     * 2）让其整体有序的过程里用外排序的方法
     * 3）利用master公式来求解时间复杂度
     * 4）归并排序的实质
     *
     * 时间复杂度O(N*logN)，额外空间复杂度O(N)
     *
     *
     *
     *
     * */
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int L, int R) {
        //结束条件
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        //先范围分解，分解到最底层用merge排序
        process(arr, 0, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int M, int R) {
        //定义辅助空间存储排序后的值
        int[] help = new int[R - L + 1];
        int i = 0;
        //定义前后指针，前指针指向左数组第一个位置，右指针指向右数组第一个位置。
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }

        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }

    //打印数组
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 6, 5, 2, 4};
        mergeSort(arr);
        printArray(arr);
    }
}
