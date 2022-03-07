package 排序相关;

/**
 * @auther lihua
 * @create 2022-03-05 22:18
 */


/*
*
* 排序原理：
 1.每一次遍历的过程中，都假定第一个索引处的元素是最小值，和其他索引处的值依次进行比较，如果当前索引处
的值大于其他某个索引处的值，则假定其他某个索引出的值为最小值，最后可以找到最小值所在的索引
 2.交换第一个索引处和最小值所在的索引处的值
*
*
* */
public class 选择排序 {
    public static void main(String[] args) {

    }

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //在i ~ N-1位置上选最小值并且放到i位置上去
        for (int i = 0; i < arr.length - 1; i++) { // i ~ N-1
            int minIndex = i;
            for (int j = i + 1; i < arr.length; j++) { // i ~ N-1上找最小值的下标
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }

            swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
