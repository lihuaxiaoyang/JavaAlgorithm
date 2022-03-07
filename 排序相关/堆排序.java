package 排序相关;

/**
 * @auther lihua
 * @create 2022-03-06 15:09
 */
public class 堆排序 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 578, 2, 46, 87, 81, 2465, 44};
        heapSort(arr);
        printArray(arr);
    }


    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
//        for (int i = 0; i < arr.length; i++) {
//            heapInsert(arr, i);
//        }

        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }


        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    //某个数现在处在index位置，往上继续移动
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // 某个数在index位置，能否往下移动
    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;//左孩子的下标
        while (left < heapSize) {
            //两个孩子中，谁的值大，把下标给largest
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            //父和孩子之间，谁的值大，把下标给largest
            //如果有右孩子，且右孩子的下标更大，就记录右孩子的下标，否则记录左孩子的下标


            //父亲和较大孩子之间，谁的值大，把下标给largest
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }

            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }


    public static void swap(int[] arr, int i, int j) {
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
}
