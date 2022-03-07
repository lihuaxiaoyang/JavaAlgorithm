package 排序相关;

/**
 * @auther lihua
 * @create 2022-03-05 23:41
 */
/*
1.把所有的元素分为两组，已经排序的和未排序的；
2.找到未排序的组中的第一个元素，向已经排序的组中进行插入；
3.倒叙遍历已经排序的元素，依次和待插入的元素进行比较，直到找到一个元素小于等于待插入元素，那么就把待
插入元素放到这个位置，其他的元素向后移动一位；
* */
public class 插入排序 {
    public static void main(String[] args) {

    }

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 0 ~ 0 有序的
        // 0 ~ i 想有序
        for (int i = 1; i < arr.length; i++) {// 0 ~ i 做到有序
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
