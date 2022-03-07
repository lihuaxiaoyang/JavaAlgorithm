package 排序相关;

/**
 * @auther lihua
 * @create 2022-03-06 14:08
 */
public class 快速排序 {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);

    }

    public static void quickSort(int[] arr, int L, int R) {
        if (L < R) {
            swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
            int[] p = partition(arr, L, R);
            quickSort(arr, L, p[0] - 1);// < 区
            quickSort(arr, p[1] + 1, R);// > 区
        }
    }

    /*
     * 这是一个处理arr[1..r]的函数
     * 默认一arr[r]做划分，arr[r] -> p  <p  ==p  >p
     * 返回等于区域(左边界，右边界)，所以返回一个长度为2的数组res
     * */
    public static int[] partition(int[] arr, int L, int R) {
        int less = L - 1;//<区右边界
        int more = R;//>区左边界
        while (L < more) {
            if (arr[L] < arr[R]) {//当前数 < 划分值
                swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) {//当前数 > 划分值
                swap(arr, --more, L);
            } else {
                L++;
            }
        }
        swap(arr, more, R);
        return new int[]{less + 1, more};
    }


    //异或运算：无进位相加，相同为0，不同为1
    /*
     * 异或运算的性质：
     * 1.0 ^ N = N ; N ^ N = 0
     * 2.异或满足交换率与结合率 a ^ b = b ^ a ; (a ^ b) ^ c = a ^ (b ^ c)
     * */
    public static void swap(int[] arr, int i, int j) {
//        arr[i] = arr[i] ^ arr[j];
//        arr[j] = arr[i] ^ arr[j];
//        arr[i] = arr[i] ^ arr[j];
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
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
        int[] arr = new int[]{1, 4, 8, 2, 1, 546, 78, 78, 455, 154,};
        quickSort(arr);
        printArray(arr);
    }
}
