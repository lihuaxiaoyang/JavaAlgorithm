package 排序相关;

import java.util.Arrays;

/**
 * @auther lihua
 * @create 2022-03-05 22:12
 */
public class 冒泡排序 {

    public static void bubbleSort(int[] arr) {
        //如果数组为空或长度小于2，则无需排序
        if (arr == null || arr.length < 2) {
            return;
        }
        //每次遍历后，数组最后一个位置就确定了
        for (int e = arr.length - 1; e > 0; e--) {
            //对每个相邻的两个位置进行调换
            for (int i = 0; i < e; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    //异或运算：无进位相加，相同为0，不同为1
    /*
     * 异或运算的性质：
     * 1.0 ^ N = N ; N ^ N = 0
     * 2.异或满足交换率与结合率 a ^ b = b ^ a ; (a ^ b) ^ c = a ^ (b ^ c)
     * */
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }


    //对数器
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // Math.random() -> [0,1) 所有的小数，等概率返回一个
        // Math.random() * N -> [0,N) 所有小数，等概率返回一个
        // (int) (Math.random() * N) -> [0,N-1] 所有的整数，等概率返回一个
        // Math.abs() -> 返回绝对值
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    //复制当前数组的一个样本
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }


    //判断两个数组是否完全相同
    public static boolean isEquals(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        if (arr1 != null && arr2 == null || arr1 == null && arr2 != null) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        return true;
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
        int testTims = 10000;//测试次数
        int maxSize = 20;//最大测试容量
        int maxNum = 20;//最大测试数据
        boolean euqals = true;
        for (int i = 0; i < testTims; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxNum);
            int[] arr2 = copyArray(arr1);//这两个数组除了
            //数值相同内存地址完全没关系，请看copyArray()方法实现
            bubbleSort(arr1);//用自己的算法排序
            comparator(arr2);//用java.util.Arrays包的排序算法排序
            if (!isEquals(arr1, arr2)) {//比较是否相同
                euqals = false;//一旦有不一样的值就设为false;
                break;
            }
        }
        System.out.println(euqals ? "Success:恭喜你！没毛病！" : "Error：抱歉，有错误");//没错就恭喜，有错就报错
        int[] newArr = generateRandomArray(maxSize, maxNum);
        printArray(newArr);//没排序的数组打印出来
        bubbleSort(newArr);//排序后
        printArray(newArr);//再次打印，程序员自己看看有没有毛病
    }

}
